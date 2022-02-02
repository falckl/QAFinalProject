package com.qa.hotel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hotel.data.entity.Room;

@Repository //signifies that this is a bean
public interface RoomRepository extends JpaRepository<Room, Long> {
	//Room = type of entity
	//Long = type of user entity id (primary key) field
		//repositories must be defined as interfaces as
		//spring & hibernate will generate the implementations
		//must specify identity & it's type

}
