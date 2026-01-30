package com.example.moattravel4.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.moattravel4.entity.MeetingRoom;
import com.example.moattravel4.form.MeetingRoomEditForm;
import com.example.moattravel4.repository.MeetingRoomRepository;

@Service
public class MeetingRoomService {

	private final MeetingRoomRepository meetingRoomRepository;

	public MeetingRoomService(MeetingRoomRepository meetingRoomRepository) {

		this.meetingRoomRepository = meetingRoomRepository;

	}

	@Transactional

	public void update(MeetingRoomEditForm meetingRoomEditForm) {

		MeetingRoom meetingRoom = meetingRoomRepository.getReferenceById(meetingRoomEditForm.getId());
		MultipartFile imageFile = meetingRoomEditForm.getImageFile();

		if (!imageFile.isEmpty()) {
			String imageName = imageFile.getOriginalFilename();
			String hashedImageName = generateNewFileName(imageName);
			Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
			copyImageFile(imageFile, filePath);
			meetingRoom.setImageName(hashedImageName);
		}

		meetingRoom.setName(meetingRoomEditForm.getName());
		meetingRoom.setDescription(meetingRoomEditForm.getDescription());
		meetingRoom.setPrice(meetingRoomEditForm.getPrice());
		meetingRoom.setCapacity(meetingRoomEditForm.getCapacity());
		meetingRoom.setPostalCode(meetingRoomEditForm.getPostalCode());
		meetingRoom.setAddress(meetingRoomEditForm.getAddress());
		meetingRoom.setPhoneNumber(meetingRoomEditForm.getPhoneNumber());

		meetingRoomRepository.save(meetingRoom);
	}

	public String generateNewFileName(String fileName) {
		String[] fileNames = fileName.split("\\.");
		for (int i = 0; i < fileNames.length - 1; i++) {
			fileNames[i] = UUID.randomUUID().toString();
		}
		String hashedFileName = String.join(".", fileNames);
		return hashedFileName;
	}

	public void copyImageFile(MultipartFile imageFile, Path filePath) {
		try {
			Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}