package playground.demo.controllers;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import playground.demo.domain.Pet;
import reactor.core.publisher.Flux;


@Controller
public class PetsController {

    WebClient petWebClient;

    PetsController(WebClient.Builder builder) {
        this.petWebClient = builder.baseUrl("http://pet-service").build();
    }

    @QueryMapping
    Flux<Pet> pets() {
        return petWebClient.get()
                .uri("/pets")
                .retrieve()
                .bodyToFlux(Pet.class);
    }
}
