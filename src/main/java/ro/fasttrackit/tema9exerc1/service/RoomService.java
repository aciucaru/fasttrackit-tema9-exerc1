package ro.fasttrackit.tema9exerc1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ro.fasttrackit.tema9exerc1.model.Review;
import ro.fasttrackit.tema9exerc1.model.RoomEntity;
import ro.fasttrackit.tema9exerc1.repository.*;

@Service
//@RequiredArgsConstructor
public class RoomService
{
	private final RoomRepository repository;
	private final RoomDAO dao;

	public RoomService(RoomRepository repository, RoomDAO dao)
	{
		this.repository = repository;
		this.dao = dao;
	}
	
	public List<RoomEntity> getAll()
	{
		return repository.findAll();
	}
	
	public Optional<RoomEntity> getById(String id)
	{
		Optional<RoomEntity> optRoom = Optional.ofNullable(null);
		if(id != null)
			optRoom = repository.findById(id);
		return optRoom;
	}

	public List<Review> getReviewsById(String id)
	{
		Optional<RoomEntity> optRoom = getById(id);
		if(optRoom.isPresent())
			return optRoom.get().reviews();
		else
			return new ArrayList<Review>(0);
	}
	
	public Optional<RoomEntity> delete(String id)
	{
		Optional<RoomEntity> optRoom = Optional.ofNullable(null);
		if(id != null)
		{
			optRoom = repository.findById(id);
			if(optRoom.isPresent())
				repository.delete(optRoom.get());
		}
		return optRoom;
	}

	public RoomEntity update(String id, JsonPatch updatedRoomEntity)
	{
		return repository.findById(id)
				.map(room -> applyPatch(room, updatedRoomEntity))
				.map(room -> replaceEntity(id, room))
				.orElseThrow(() -> new RuntimeException());
	}

	private RoomEntity applyPatch(RoomEntity room, JsonPatch updatedRoom)
	{
		try
		{
			ObjectMapper jsonMapper = new ObjectMapper();
			JsonNode jsonNode = jsonMapper.convertValue(room, JsonNode.class);
			JsonNode patchedJsonNode = updatedRoom.apply(jsonNode);
			return jsonMapper.treeToValue(patchedJsonNode, RoomEntity.class);
//			return jsonMapper.toEntity(jsonMapper.treeToValue(patchedJsonNode, RoomEntity.class));
		}
		catch(JsonProcessingException | JsonPatchException excep)
		{ throw new RuntimeException(excep); }
	}

	public RoomEntity replaceEntity(String id, RoomEntity newEntity)
	{
		RoomEntity room = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Could not find room"));

		return repository.save(room); // ?? gresit, cum este corect de fapt?
	}
}
