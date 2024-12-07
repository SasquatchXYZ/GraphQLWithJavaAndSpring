package playground.demo.controllers;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import playground.demo.domain.Pet;

import java.util.List;

@Controller
public class PetsController {

    @QueryMapping
    List<Pet> pets() {
        return List.of(
                new Pet("Luna", "cappuccino"),
                new Pet("Skipper", "black")
        );
    }
}
