package com.example.moattravel4.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moattravel4.entity.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

	public Page<MeetingRoom> findByNameLike(String keyword, Pageable pageable);

	public List<MeetingRoom> findTop10ByOrderByCreatedAtDesc();

	// 以下、検索用メソッド
	public Page<MeetingRoom> findByNameLikeOrAddressLike(String nameKeyword, String addressKeyword, Pageable pageable);

	public Page<MeetingRoom> findByAddressLike(String area, Pageable pageable);

	public Page<MeetingRoom> findByPriceLessThanEqual(Integer price, Pageable pageable);

	// 以下、並べ替え用メソッド
	public Page<MeetingRoom> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	public Page<MeetingRoom> findByNameLikeOrAddressLikeOrderByPriceAsc(String nameKeyword, String addressKeyword,
			Pageable pageable);

	public Page<MeetingRoom> findByAddressLikeOrderByCreatedAtDesc(String area, Pageable pageable);

	public Page<MeetingRoom> findByAddressLikeOrderByPriceAsc(String area, Pageable pageable);

	public Page<MeetingRoom> findByPriceLessThanEqualOrderByCreatedAtDesc(Integer price, Pageable pageable);

	public Page<MeetingRoom> findByPriceLessThanEqualOrderByPriceAsc(Integer price, Pageable pageable);

	public Page<MeetingRoom> findAllByOrderByCreatedAtDesc(Pageable pageable);

	public Page<MeetingRoom> findAllByOrderByPriceAsc(Pageable pageable);
}