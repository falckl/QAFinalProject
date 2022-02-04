package com.qa.hotel.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.data.repository.RoomRepository;


@SpringBootTest
@Transactional
public class RoomServiceIntegrationTest {
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomRepository roomRepository;
	
	private List<Room> roomsInDb;
	private long nextNewId;
	
	
	@BeforeEach
	public void init() {
		roomsInDb = new ArrayList<>();
		Room room1 = new Room(1L,"Twin Room", 2, 2, "En-suite");
		Room room2 = new Room(2L,"Double Room", 1, 2, "En-suite");
		Room room3 = new Room(3L,"Family Room", 3, 4, "En-suite");
		roomsInDb.addAll(List.of(room1, room2, room3));
		int size = roomsInDb.size();
		nextNewId = roomsInDb.get(size - 1).getId() + 1;
		
	}
	
	@Test
	public void getAllTest() {
		assertThat(roomsInDb).isEqualTo(roomService.getAll());
	}
	
	@Test
	public void getByIdTest() {
		Room toGet = new Room("Twin Room", 2, 2, "En-suite");
		Room expectedRoom = new Room(nextNewId, toGet.getName(),
				toGet.getNumBeds(), toGet.getNumGuests(),
				toGet.getBathroom());
		roomRepository.save(expectedRoom);
		assertThat(expectedRoom).isEqualTo(roomService.getById(nextNewId));	
	}
	
	@Test
	public void createTest() {
		Room toCreate = new Room("Twin Room", 2, 2, "En-suite");
		Room expectedRoom = new Room(nextNewId, toCreate.getName(),
				toCreate.getNumBeds(), toCreate.getNumGuests(),
				toCreate.getBathroom());
		Room created = roomService.createRoom(toCreate);
		assertThat(expectedRoom.equals(created)).isEqualTo(true);
	}
	
	@Test
	public void updateTest () {
		Room toUpdate = new Room("Twin Room", 2, 2, "En-suite");
		Room expectedRoom = new Room(1L, "Twin Room", 2, 2, "En-suite");
		assertThat(expectedRoom).isEqualTo(roomService.updateRoom(1L, toUpdate));
	}
	
	@Test
	public void deleteTest() {
		Room roomToDelete = roomsInDb.get(0);
		long id = roomToDelete.getId();
		roomService.deleteRoom(id);
		assertThat(roomRepository.findById(id)).isEqualTo(Optional.empty());
	}
	
	@Test
	public void hashCodeTest() {
	    Room x = new Room(1L, "Quadruple Room", 4, 4, "En-suite");
	    Room y = new Room(1L, "Quadruple Room", 4, 4, "En-suite");
	    assertThat(x.equals(y) && y.equals(x)).isEqualTo(true);
	    assertThat(x.hashCode() == y.hashCode()).isEqualTo(true);
	}

}
