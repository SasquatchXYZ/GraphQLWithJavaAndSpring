package playground.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
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

    @SchemaMapping(typeName = "Pet", field = "owner")
    Person owner(Pet pet) {
        return petService.getPerson(pet.ownerId());
    }
}
