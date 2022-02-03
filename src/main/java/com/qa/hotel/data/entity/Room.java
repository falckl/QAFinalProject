package com.qa.hotel.data.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@Table (name = "room")
public class Room {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id = 0L;
	
	@NotNull
	@Length(min = 1, message = "Please specify room type name.")
	private String name;
	
	@Max(value = 50)
	@Min(value = 1)
	private int numBeds;
	
	@Max(value = 50)
	@Min(value = 1)
	private int numGuests;
	
	@NotNull
	@Length(min = 1, message = "Please specify bathroom type.")
	private String bathroom;
	
	public Room() {
		super();
	}
	
	public Room(Long id, String name, int numBeds, int numGuests, String bathroom) {
		super();
		this.id = id;
		this.name = name;
		this.numBeds = numBeds;
		this.numGuests = numGuests;
		this.bathroom = bathroom;
	}
	
	public Room(String name, int numBeds, int numGuests, String bathroom) {
		super();
		this.name = name;
		this.numBeds = numBeds;
		this.numGuests = numGuests;
		this.bathroom = bathroom;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumBeds() {
		return numBeds;
	}
	
	public void setNumBeds(int numBeds) {
		this.numBeds = numBeds;
	}
	
	public int getNumGuests() {
		return numGuests;
	}
	
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}
	
	public String getBathroom() {
		return bathroom;
	}
	
	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(numBeds, other.numBeds) && Objects.equals(numGuests, other.numGuests)
				&& Objects.equals(bathroom, other.bathroom);
	}
	


}
