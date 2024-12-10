package playground.demo.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;
import playground.demo.domain.Person;
import playground.demo.domain.Pet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class PetsController {

    WebClient petWebClient;
    WebClient ownerWebClient;

    PetsController(WebClient.Builder builder) {
        this.petWebClient = builder.baseUrl("http://pet-service").build();
        this.ownerWebClient = builder.baseUrl("http://owner-service").build();
    }

    @QueryMapping
    Flux<Pet> pets() {
        return petWebClient.get()
                .uri("/pets")
                .retrieve()
                .bodyToFlux(Pet.class);
    }

    @SchemaMapping
    Mono<Person> owner(Pet pet) {
        return ownerWebClient.get()
                .uri("/owner/{id}", pet.ownerId())
                .retrieve()
                .bodyToMono(Person.class);
    }

    @QueryMapping
    Mono<Pet> pet(@Argument String id) {
        return petWebClient.get()
                .uri("/pets/{id}", id)
                .retrieve()
                .bodyToMono(Pet.class);
    }
}
