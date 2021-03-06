package com.producer.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class CarRunningStatusDTO implements Serializable {
	

	private static final long serialVersionUID = -7257446436956236433L;
	private String id;
	private List<Integer> latlong;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	public LocalDateTime timestamp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Integer> getLatlong() {
		return latlong;
	}

	public void setLatlong(List<Integer> latlong) {
		this.latlong = latlong;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public CarRunningStatusDTO(String id, List<Integer> latlong, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.latlong = latlong;
		this.timestamp = timestamp;
	}

	
}
