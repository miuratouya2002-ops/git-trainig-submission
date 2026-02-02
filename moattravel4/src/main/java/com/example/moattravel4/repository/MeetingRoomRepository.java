package com.example.moattravel4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel4.entity.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

	public Page<MeetingRoom> findByNameLike(String keyword, Pageable pageable);

	// 名称または住所であいまい検索
	public Page<MeetingRoom> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword, Pageable pageable);

	// 住所であいまい検索
	public Page<MeetingRoom> findByAddressLike(String area, Pageable pageable);

	// 指定した価格以下で検索
	public Page<MeetingRoom> findByPriceLessThanEqual(Integer price, Pageable pageable);
}