package com.example.moattravel4.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

	// 予約情報を登録するメソッド
	@Transactional
	public void create(ReservationRegisterForm reservationRegisterForm) {
		Reservation reservation = new Reservation();

		// 会議室情報を取得 (MeetingRoomRepositoryを使用)
		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(reservationRegisterForm.getMeetingRoomId());

		User user = userRepository.getReferenceById(reservationRegisterForm.getUserId());

		// 日付データを文字列からLocalDate型に変換
		LocalDate checkinDate = LocalDate.parse(reservationRegisterForm.getCheckinDate());
		LocalDate checkoutDate = LocalDate.parse(reservationRegisterForm.getCheckoutDate());

		// エンティティに値をセット
		reservation.setMeetingRoom(meetingRoom);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(reservationRegisterForm.getNumberOfPeople());
		reservation.setAmount(reservationRegisterForm.getAmount());

		// データベースに保存
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