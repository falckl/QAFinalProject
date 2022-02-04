package com.qa.hotel.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.service.RoomService;


@WebMvcTest(RoomController.class)
public class RoomControllerWebIntegrationTest {
	
	@Autowired
	private RoomController controller;
	
	//fake userService
	@MockBean
	private RoomService roomService;
	
	private List<Room> rooms;
	private Room toCreate;
	private Room validRoom;
	
	@BeforeEach
	public void init() {
		rooms = new ArrayList<>();
		Room room1 = new Room(1L,"Twin Room", 2, 2, "En-suite");
		Room room2 = new Room(2L,"Double Room", 1, 2, "En-suite");
		Room room3 = new Room(3L,"Family Room", 3, 4, "En-suite");
		rooms.addAll(List.of(room1, room2, room3));
		toCreate = new Room("Twin Room", 2, 2, "En-suite");
		validRoom = new Room(1L,"Twin Room", 2, 2, "En-suite");
	}
	
	@Test
	public void getAllTest() {
		ResponseEntity<List<Room>> expected = new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		when(roomService.getAll()).thenReturn(rooms);
		ResponseEntity<List<Room>> actual = controller.getRooms();
		assertThat(expected).isEqualTo(actual);
		verify(roomService, times(1)).getAll();
	}
	
	@Test
	public void getByIdTest() {
		ResponseEntity<Room> expected = new ResponseEntity<Room>(validRoom, HttpStatus.OK);
		when(roomService.getById(validRoom.getId())).thenReturn(validRoom);
		ResponseEntity<Room> actual = controller.getRoomById(validRoom.getId());
		assertThat(expected).isEqualTo(actual);
		verify(roomService, times(1)).getById(validRoom.getId());
		
	}
	
	@Test
	public void createTest() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/room/" + String.valueOf(validRoom.getId()));
		ResponseEntity<Room> expected = new ResponseEntity<Room>(validRoom, headers, HttpStatus.CREATED);
		when(roomService.createRoom(toCreate)).thenReturn(validRoom);
		ResponseEntity<Room> actual = controller.createRoom(toCreate);
		assertEquals(expected, actual);
		verify(roomService).createRoom(toCreate);
		
	}
	
	@Test
	public void updateTest() {
		Room updatedDetails = new Room(1L,"Twin", 2, 2, "En-suite");
		Room newDetails = new Room("Twin", 2, 2, "En-suite");
		long id = updatedDetails.getId();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/room/" + String.valueOf(id));
		ResponseEntity<Room> expected = new ResponseEntity<Room>(updatedDetails, headers, HttpStatus.ACCEPTED);
		when(roomService.updateRoom(id, newDetails)).thenReturn(updatedDetails);
		ResponseEntity<Room> actual = controller.updateRoom(id, newDetails);
		assertEquals(expected, actual);
		verify(roomService, times(1)).updateRoom(id, newDetails);
	}
	
	@Test
	public void deleteTest() {
		long idToDelete = validRoom.getId();
//		
		ResponseEntity<?> expected = ResponseEntity.accepted().build();
		ResponseEntity<?> actual = controller.deleteRoom(idToDelete);
		
		assertEquals(expected, actual);
		verify(roomService, times(1)).deleteRoom(idToDelete);
	}
	
	
	
	
	

}
