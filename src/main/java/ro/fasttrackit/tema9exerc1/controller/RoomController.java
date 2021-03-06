package ro.fasttrackit.tema9exerc1.controller;

import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.tema9exerc1.model.*;
import ro.fasttrackit.tema9exerc1.service.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
public class RoomController
{
	private final RoomService service;
	
	public RoomController(RoomService service)
	{
		this.service = service;
	}
	
	@GetMapping
	List<RoomEntity> getAll() { return service.getAll(); }

	@GetMapping("{id}")
	RoomEntity getById(@PathVariable String id)
	{
		Optional<RoomEntity> optRoom = service.getById(id);

		if(optRoom.isPresent())
			return optRoom.get();
		else
			return null;
	}

	@GetMapping("{id}/reviews")
	List<Review> getReviewsById(@PathVariable String id)
	{
		return service.getReviewsById(id);
	}
	
	@DeleteMapping("{id}")
	RoomEntity delete(@PathVariable String id)
	{
		Optional<RoomEntity> optRoom = null;

		if (id != null)
			optRoom = service.delete(id);

		if (optRoom.isPresent())
			return optRoom.get();
		else
			return null;
	}

	@PatchMapping("{id}")
	RoomEntity update(@PathVariable String id, @RequestBody JsonPatch updatedRoomEntity)
	{
		return service.update(id, updatedRoomEntity);
	}
}
