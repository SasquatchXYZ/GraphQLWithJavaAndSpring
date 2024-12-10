package playground.demo.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import playground.demo.domain.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;


@Controller
public class PetsController {

    WebClient petWebClient;
    WebClient ownerWebClient;

    PetsController(WebClient.Builder builder) {
        this.petWebClient = builder.baseUrl("http://pet-service").build();
        this.ownerWebClient = builder.baseUrl("http://owner-service").build();
    }

    @QueryMapping
    Flux<Object> creatures() {
        // Add your fetching logic

        // In-memory example
        return Flux.just(
                new Dog("Dog01", "Spot", "Yellow", true),
                new Cat("Cat01", "Chicken", "Orange", true),
                new Human("Donna")
        );
    }

    @MutationMapping
    Mono<ChangePetNamePayload> changePetName(
            @Argument String id,
            @Argument String newName
    ) {
        Map<String, String> changeNameBody = Map.of(
                "name", newName
        );

        return petWebClient.put()
                .uri("/pets/{id}")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(changeNameBody))
                .retrieve()
                .bodyToMono(ChangePetNamePayload.class);
    }
}
