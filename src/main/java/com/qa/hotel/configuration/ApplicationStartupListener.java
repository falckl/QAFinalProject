package com.qa.hotel.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.hotel.data.entity.Room;
import com.qa.hotel.data.repository.RoomRepository;

@Profile("production")
@Configuration
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {
	
private RoomRepository roomRepository;
	
	@Autowired // dependency injection
	public ApplicationStartupListener(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	
	// The application has booted and its components are ready to server
	// content when this method fires
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		roomRepository.saveAll(List.of(
				new Room("Twin Room", 2, 2, "En-suite"),
				new Room("Double Room", 1, 2, "En-suite"),
				new Room("Family Room", 3, 4, "En-suite")
		));
	}


}
