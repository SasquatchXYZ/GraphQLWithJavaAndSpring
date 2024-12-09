package playground.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import playground.demo.domain.Cat;
import playground.demo.domain.Dog;
import playground.demo.domain.Person;
import playground.demo.domain.Pet;
import playground.demo.service.PetService;


@Controller
public class PetsController {

    @Autowired
    PetService petService;

    @QueryMapping
    Pet favoritePet() {
        return petService.getFavoritePet();
    }

    @SchemaMapping
    Person owner(Dog dog) {
        return petService.getPerson(dog.ownerId());
    }

    @SchemaMapping
    Person owner(Cat cat) {
        return petService.getPerson(cat.ownerId());
    }
}
