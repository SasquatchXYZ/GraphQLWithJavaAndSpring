package playground.demo.service;

import org.springframework.stereotype.Service;
import playground.demo.domain.Person;
import playground.demo.domain.Pet;

@Service
public class PetService {

    public Pet getFavoritePet() {
        return new Pet("Skipper", "Dalton");
    }

    public Person getPerson(String ownerId) {
        return new Person(ownerId, "Dalton", "Ricker");
    }
}
