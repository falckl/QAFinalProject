package com.qa.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	private RoomService roomService;
	
	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	//CRUD methods
	
	@GetMapping
	public ResponseEntity<List<Room>> getRooms() {
		ResponseEntity<List<Room>> rooms = ResponseEntity.ok(roomService.getAll());
		return rooms;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable("id") Long id) {
		Room roomInDb = roomService.getById(id);
		ResponseEntity<Room> response = ResponseEntity.ok(roomInDb);
		return response;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
		Room savedRoom = roomService.createRoom(room);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/room/" + String.valueOf(savedRoom.getId()));
		
		ResponseEntity<Room> response = new ResponseEntity<Room>(savedRoom, headers, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable("id") Long id, @Valid @RequestBody Room room) {
		Room updatedRoom = roomService.updateRoom(id,  room);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/room/" + String.valueOf(updatedRoom.getId()));
		
		ResponseEntity<Room> response = new ResponseEntity<Room>(updatedRoom, headers, HttpStatus.ACCEPTED);
		return response;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable("id") Long id) {
		roomService.deleteRoom(id);
		return ResponseEntity.accepted().build();
	}
	

}