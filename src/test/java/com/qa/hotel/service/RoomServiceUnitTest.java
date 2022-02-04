package com.qa.hotel.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.data.repository.RoomRepository;
import com.qa.hotel.exceptions.RoomNotFoundException;


//use Mockito for test environment
@ExtendWith(MockitoExtension.class)
public class RoomServiceUnitTest {
	
	@Mock
	private RoomRepository roomRepository;
	
	@InjectMocks
	private RoomService roomService;
	
	private List<Room> rooms;
	private Room expectedRoomWithId;
	private Room expectedRoomNoId;
	private long id = 1L;
	private long exceptionId = 5L;
	
	@BeforeEach //run before every test to set up above 
	public void init() {
		rooms = new ArrayList<>();
		Room room1 = new Room(1L,"Twin Room", 2, 2, "En-suite");
		Room room2 = new Room(2L,"Double Room", 1, 2, "En-suite");
		Room room3 = new Room(3L,"Family Room", 3, 4, "En-suite");
		rooms.addAll(List.of(room1, room2, room3));
		expectedRoomWithId = room1;
		expectedRoomNoId = new Room("Twin Room", 2, 2, "En-suite");
	}
	
	
	
	//test each method
	
	//test Get All
	@Test
	public void getAllTest() {
		when(roomRepository.findAll()).thenReturn(rooms);
		assertThat(roomService.getAll()).isEqualTo(rooms);
		verify(roomRepository, times(1)).findAll();
	}
	
	//test Get By Id
	@Test
	public void getByIdTest() {
		when(roomRepository.existsById(id)).thenReturn(true);
		when(roomRepository.findById(id)).thenReturn(Optional.of(expectedRoomWithId));
		assertThat(roomService.getById(id)).isEqualTo(expectedRoomWithId);
		verify(roomRepository, times(1)).findById(id);
		verify(roomRepository, times(1)).existsById(id);
	}
	
	//test Get By Id exception
	@Test
	public void getByIdExceptionTest() {
		when(roomRepository.existsById(exceptionId)).thenReturn(false);
		try {
            roomService.getById(exceptionId);
            
        } catch (RoomNotFoundException e) {
            assertThat(e.getMessage().equals("Room with id: " + String.valueOf(exceptionId) + " not found in the system."));
        }
		verify(roomRepository, times(1)).existsById(exceptionId);
	}
	
	//test Create
	@Test
	public void createTest() {
		when(roomRepository.save(expectedRoomNoId)).thenReturn(expectedRoomWithId);
		assertThat(roomService.createRoom(expectedRoomNoId)).isEqualTo(expectedRoomWithId);
		verify(roomRepository, times(1)).save(expectedRoomNoId);
	}
	
	//test Update
	@Test
	public void updateTest() {
		Room RoomWithUpdates = new Room(expectedRoomWithId.getId(),
				expectedRoomWithId.getName(),
				expectedRoomWithId.getNumBeds(),
				expectedRoomWithId.getNumGuests(),
				expectedRoomWithId.getBathroom());
		when(roomRepository.existsById(id)).thenReturn(true);
		when(roomRepository.getById(id)).thenReturn(expectedRoomWithId);
		when(roomRepository.save(expectedRoomWithId)).thenReturn(RoomWithUpdates);
		assertThat(roomService.updateRoom(id, RoomWithUpdates)).isEqualTo(RoomWithUpdates);
		verify(roomRepository, times(1)).existsById(id);
		verify(roomRepository, times(1)).getById(id);
		verify(roomRepository, times(1)).save(expectedRoomWithId);
	}
	
	//test Update exception
		@Test
	public void updateExceptionTest() {
		when(roomRepository.existsById(exceptionId)).thenReturn(false);
		try {
            roomService.updateRoom(exceptionId, expectedRoomNoId);
            
        } catch (RoomNotFoundException e) {
            assertThat(e.getMessage().equals("Room with id: " + String.valueOf(exceptionId) + " not found in the system."));
        }
		verify(roomRepository, times(1)).existsById(exceptionId);
	}
	
	//test Delete
	@Test
	public void deleteTest() {
		when(roomRepository.existsById(id)).thenReturn(true);
		roomService.deleteRoom(id);
		verify(roomRepository, times(1)).existsById(id);
		verify(roomRepository, times(1)).deleteById(id);
	}
	
	//test Delete exception
	@Test
	public void deleteExceptionTest() {
		when(roomRepository.existsById(exceptionId)).thenReturn(false);
		try {
            roomService.deleteRoom(exceptionId);
            
        } catch (RoomNotFoundException e) {
            assertThat(e.getMessage().equals("Room with id: " + String.valueOf(exceptionId) + " not found in the system."));
        }
		verify(roomRepository, times(1)).existsById(exceptionId);
	}
		

}
