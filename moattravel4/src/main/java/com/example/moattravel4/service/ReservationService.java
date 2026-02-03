package com.example.moattravel4.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.entity.Reservation;
import com.example.moattravel4.entity.User;
import com.example.moattravel4.form.ReservationRegisterForm;
import com.example.moattravel4.repository.MeetingRoomRepository;
import com.example.moattravel4.repository.ReservationRepository;
import com.example.moattravel4.repository.UserRepository;

@Service
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final MeetingRoomRepository meetingRoomRepository;
	private final UserRepository userRepository;

	public ReservationService(ReservationRepository reservationRepository, MeetingRoomRepository meetingRoomRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.meetingRoomRepository = meetingRoomRepository;
		this.userRepository = userRepository;
	}

	// フォームから直接登録する場合のメソッド
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(reservationRegisterForm.getMeetingRoomId());
		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());
		LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
		LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());

		reservation.setMeetingRoom(meetingRoom);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		reservation.setAmount(reservationRegisterForm.getAmount());

		reservationRepository.save(reservation);
	}

	// Stripeからの決済情報を使って予約を登録するメソッド
	@Transactional
	public void create(Map<String, String> paymentIntentObject) {
		Reservation reservation = new Reservation();

		Integer meetingRoomId = Integer.valueOf(paymentIntentObject.get("meetingRoomId"));
		Integer userId = Integer.valueOf(paymentIntentObject.get("userId"));

		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(meetingRoomId);
		User user = userRepository.getReferenceById(userId);

		LocalDate checkinDate = LocalDate.parse(paymentIntentObject.get("checkinDate"));
		LocalDate checkoutDate = LocalDate.parse(paymentIntentObject.get("checkoutDate"));
		Integer numberOfPeople = Integer.valueOf(paymentIntentObject.get("numberOfPeople"));
		Integer amount = Integer.valueOf(paymentIntentObject.get("amount"));

		reservation.setMeetingRoom(meetingRoom);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(numberOfPeople);
		reservation.setAmount(amount);

		reservationRepository.save(reservation);
	}

	// 宿泊人数が定員以下かどうかをチェックする
	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	// 宿泊料金を計算する
	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		int amount = price * (int) numberOfNights;
		return amount;
	}
}