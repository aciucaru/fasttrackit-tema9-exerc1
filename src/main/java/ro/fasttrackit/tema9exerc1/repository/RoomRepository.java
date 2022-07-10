package ro.fasttrackit.tema9exerc1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import ro.fasttrackit.tema9exerc1.model.RoomEntity;

public interface RoomRepository extends MongoRepository<RoomEntity, String>
{

}
