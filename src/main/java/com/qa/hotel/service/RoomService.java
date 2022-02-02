package com.qa.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.data.repository.RoomRepository;
import com.qa.hotel.exceptions.RoomNotFoundException;

public class RoomService {
	

	private RoomRepository roomRepository;
	
	@Autowired // dependency injection
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	
	//CRUD methods:
	
	//Get all
	public List<Room> getAll() {
		return roomRepository.findAll();
		//List<Room> rooms = new ArrayList<>(List.of(new Room("double room", 1, 2, "ensuite")));
		//return rooms;
	}
	
	//Get by Id
	public Room getById(long id) {
		if (roomRepository.existsById(id)) {
			Room room = roomRepository.findById(id).get();
			return room;
		} throw new RoomNotFoundException("Room with id: " + String.valueOf(id) + " not found in the system.");
	}
	
	//Create
	public Room createRoom(Room room) {
		Room savedRoom = roomRepository.save(room);
		return savedRoom;
	}
	
	//Update
	public Room updateRoom(long id, Room room) {
		if (roomRepository.existsById(id)) {
			
			Room roomToUpdate = roomRepository.getById(id);
			
			roomToUpdate.setName(room.getName());
			roomToUpdate.setNumBeds(room.getNumBeds());
			roomToUpdate.setNumGuests(room.getNumGuests());
			roomToUpdate.setBathroom(room.getBathroom());
			
			return roomRepository.save(roomToUpdate);
			
		} throw new RoomNotFoundException("Room with id: " + String.valueOf(id) + " not found in the system.");
	}
	
	//Delete
	public Room deleteRoom(long id) {
		if (roomRepository.existsById(id)) {
			Room deletedRoom = roomRepository.getById(id);
			roomRepository.deleteById(id);
			return deletedRoom;
		} throw new RoomNotFoundException("Room with id: " + String.valueOf(id) + " not found in the system.");
	}

}
