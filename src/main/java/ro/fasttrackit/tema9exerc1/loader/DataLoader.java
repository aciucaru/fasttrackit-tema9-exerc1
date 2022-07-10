package ro.fasttrackit.tema9exerc1.loader;

import java.util.List;
import static java.util.UUID.randomUUID;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.fasttrackit.tema9exerc1.repository.RoomRepository;
import ro.fasttrackit.tema9exerc1.model.*;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner
{
    private final RoomRepository repository;

    @Override
    public void run(String... args) throws Exception
    {
        Review review1 = new Review("Camera luxoasa si curata", 9, "Andrei");
        RoomFacilities facilities1 = new RoomFacilities(true, true);
        RoomEntity room1 = new RoomEntity(randomUUID().toString(), "A1", 1, "Union Plaza", facilities1, review1);

        Review review2 = new Review("Camera foarte curata, mobilier modern si luxos", 10, "Mihai");
        RoomFacilities facilities2 = new RoomFacilities(true, true);
        RoomEntity room2 = new RoomEntity(randomUUID().toString(), "A2", 1, "Union Plaza", facilities2, review2);

        Review review3 = new Review("Camera 5*, servire ireprosabila, recomand", 10, "Alex");
        RoomFacilities facilities3 = new RoomFacilities(true, true);
        RoomEntity room3 = new RoomEntity(randomUUID().toString(), "B5", 2, "Union Plaza", facilities3, review3);

        Review review4 = new Review("Camera destul de curata, locatie centrala", 7, "Radu");
        RoomFacilities facilities4 = new RoomFacilities(true, false);
        RoomEntity room4 = new RoomEntity(randomUUID().toString(), "12", 1, "Ambiance Hotel", facilities4, review4);

        Review review5 = new Review("Destul de ok petrnu 3*, baie curata", 8, "Olivia");
        RoomFacilities facilities5 = new RoomFacilities(true, false);
        RoomEntity room5 = new RoomEntity(randomUUID().toString(), "13", 1, "Ambiance Hotel", facilities5, review5);

        Review review6 = new Review("Camera ingrijita, mobilier modern", 9, "Cosmin");
        RoomFacilities facilities6 = new RoomFacilities(true, false);
        RoomEntity room6 = new RoomEntity(randomUUID().toString(), "28", 2, "Ambiance Hotel", facilities6, review6);

        repository.save(room1);
        repository.save(room2);
        repository.save(room3);
        repository.save(room4);
        repository.save(room5);
        repository.save(room6);

//        System.out.println(repository.findAll());
    }
}
