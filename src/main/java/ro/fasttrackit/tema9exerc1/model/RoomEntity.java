package ro.fasttrackit.tema9exerc1.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "rooms")
public record RoomEntity(@Id String id,
						 String number,
						 Integer etaj,
						 String hotelName,
						 RoomFacilities roomFacilities,
						 Review review
						 )
{

}
