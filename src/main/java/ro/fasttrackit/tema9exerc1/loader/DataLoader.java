package ro.fasttrackit.tema9exerc1.loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.UUID.randomUUID;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ro.fasttrackit.tema9exerc1.repository.RoomRepository;
import ro.fasttrackit.tema9exerc1.model.*;

@Component
//@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner
{
    private final RoomRepository repository;

    public DataLoader(RoomRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        RoomFacilities facilitiesA = new RoomFacilities(true, true);
        Review reviewA1 = new Review("Camera luxoasa si curata", 9, "Andrei");
        Review reviewA2 = new Review("Hotel foarte curat si modern", 10, "Marian");
        List<Review> reviewsA = new ArrayList<>(Arrays.asList(reviewA1, reviewA2));
        RoomEntity roomA = new RoomEntity(randomUUID().toString(), "A1", 1, "Union Plaza", facilitiesA, reviewsA);

        RoomFacilities facilitiesB = new RoomFacilities(true, true);
        Review reviewB1 = new Review("Mobilier foarte luxos, hotel curat", 10, "Mihai");
        Review reviewB2 = new Review("O camera foarte mare, baie foarte luxoasa", 10, "Alex");
        Review reviewB3 = new Review("Camera de 5*, cu vedere foarte frumoasa", 9, "Radu");
        List<Review> reviewsB = new ArrayList<>(Arrays.asList(reviewB1, reviewB2, reviewB3));
        RoomEntity roomB = new RoomEntity(randomUUID().toString(), "A2", 1, "Union Plaza", facilitiesB, reviewsB);

        RoomFacilities facilitiesC = new RoomFacilities(true, true);
        Review reviewC1 = new Review("Camera 5*, servire ireprosabila, recomand", 9, "Alex");
        Review reviewC2 = new Review("Camera moderna si spatioasa, foarte curat", 10, "Andrei");
        List<Review> reviewsC = new ArrayList<>(Arrays.asList(reviewC1, reviewC2));
        RoomEntity roomC = new RoomEntity(randomUUID().toString(), "B5", 2, "Union Plaza", facilitiesC, reviewsC);

        RoomFacilities facilitiesD = new RoomFacilities(true, false);
        Review reviewD1 = new Review("Camera destul de curata, locatie centrala", 7, "Radu");
        Review reviewD2 = new Review("Hotel ok, camera ingrijita", 7, "Olivia");
        Review reviewD3 = new Review("Camera destul de mica, dar ingrijita", 8, "Cosmin");
        List<Review> reviewsD = new ArrayList<>(Arrays.asList(reviewD1, reviewD2, reviewD3));
        RoomEntity roomD = new RoomEntity(randomUUID().toString(), "12", 1, "Ambiance Hotel", facilitiesD, reviewsD);

        RoomFacilities facilitiesE = new RoomFacilities(true, false);
        Review reviewE1 = new Review("Destul de ok pentru 3*, baie curata", 8, "Olivia");
        List<Review> reviewsE = new ArrayList<>(Arrays.asList(reviewE1));
        RoomEntity roomE = new RoomEntity(randomUUID().toString(), "13", 1, "Ambiance Hotel", facilitiesE, reviewsE);

        RoomFacilities facilitiesF = new RoomFacilities(true, false);
        Review reviewF1 = new Review("Camera curata, baie in regula", 9, "Cosmin");
        Review reviewF2 = new Review("Camera la etajul 2, vedere frumoasa", 7, "Andrei");
        Review reviewF3 = new Review("Hotel curat, baie mica dar curata, vedere frumoasa", 8, "Alex");
        List<Review> reviewsF = new ArrayList<>(Arrays.asList(reviewE1));
        RoomEntity roomF = new RoomEntity(randomUUID().toString(), "28", 2, "Ambiance Hotel", facilitiesF, reviewsF);

        repository.save(roomA);
        repository.save(roomB);
        repository.save(roomC);
        repository.save(roomD);
        repository.save(roomE);
        repository.save(roomF);
    }
}
