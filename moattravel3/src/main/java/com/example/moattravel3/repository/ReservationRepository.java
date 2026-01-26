package com.example.moattravel3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel3.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
