package playground.demo.domain;

public record Cat(String name, String ownerId, Boolean doesMeow) implements Pet {
}
