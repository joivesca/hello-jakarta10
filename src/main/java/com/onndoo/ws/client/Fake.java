package com.onndoo.ws.client;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fake {

	private String id;
	private String title;
	private Double price;
	private String description;
	private String category;
	private String image;
	private Rating rating;
	
	@Override
	public String toString() {
		return "Fake [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description
				+ ", category=" + category + ", image=" + image + "]";
	}
	
	
}
