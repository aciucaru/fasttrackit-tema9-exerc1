package ro.fasttrackit.tema9exerc1.service;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.fge.jsonpatch.JsonPatch;
//import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.tema9exerc1.model.RoomEntity;
import ro.fasttrackit.tema9exerc1.repository.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService
{
	private RoomRepository repository;
	private RoomDAO dao;
	
	public List<RoomEntity> getAll()
	{
		return repository.findAll();
	}
	
	public Optional<RoomEntity> getById(String id)
	{
		Optional<RoomEntity> optRoom = null;

		if(id != null)
			optRoom = repository.findById(id);
		else
			optRoom = Optional.ofNullable(null);

		return optRoom;
	}
	
    public Optional<RoomEntity> replaceEntity(String id, RoomEntity newEntity)
    {
    	Optional<RoomEntity> optRoom = null;
    	if(id != null)
    		optRoom = repository.findById(id);
        return optRoom;
    }
	
	public Optional<RoomEntity> delete(String id)
	{
		Optional<RoomEntity> optRoom = null;

		if(id != null)
		{
			optRoom = repository.findById(id);
			if(optRoom.isPresent())
				repository.delete(optRoom.get());
		}
		else
			optRoom = Optional.ofNullable(null);

		return optRoom;
	}
}
