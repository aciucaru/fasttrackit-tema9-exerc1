package ro.fasttrackit.tema9exerc1.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Builder
@Document(collection = "rooms")
public record RoomEntity(@Id String id,
						 String number,
						 Integer etaj,
						 String hotelName,
						 RoomFacilities roomFacilities,
						 List<Review> reviews
						 )
{
	public RoomEntity(String id, String number, Integer etaj, String hotelName,
					  RoomFacilities roomFacilities, List<Review> reviews)
	{
		this.id = id;
		this.number = number;
		this.etaj = etaj;
		this.hotelName = hotelName;
		this.roomFacilities = roomFacilities;
		this.reviews = reviews;
	}
}
