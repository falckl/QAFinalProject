package com.qa.hotel.exceptions;

import javax.persistence.EntityNotFoundException;

public class RoomNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public RoomNotFoundException() {
		super();
	}

	public RoomNotFoundException(String message) {
		super(message);
	}
	
}