package com.example.moattravel4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel4.entity.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

	public Page<MeetingRoom> findByNameLike(String keyword, Pageable pageable);

}
