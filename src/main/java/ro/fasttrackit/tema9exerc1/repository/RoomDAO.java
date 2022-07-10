package ro.fasttrackit.tema9exerc1.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
//@RequiredArgsConstructor
public class RoomDAO
{
    private final MongoTemplate mongo; // ce rol are??

    public RoomDAO(MongoTemplate mongo)
    {
        this.mongo = mongo;
    }
}
