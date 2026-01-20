package com.example.moattravel3.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "houses")
@Data

public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private string name;

	@Column(name = "image_name")
	private string imageName;

	@Column(name = "description")
	private string description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "postal_code")
	private string postalcode;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private string phoneNumber;

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;

}
