package com.example.moattravel4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel4.entity.Reservation;
import com.example.moattravel4.entity.User;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	// ログイン中のユーザーの予約を作成日時の降順（新しい順）で取得
	public Page<Reservation> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
}