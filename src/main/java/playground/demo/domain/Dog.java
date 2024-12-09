package playground.demo.domain;

public record Dog(String name, String ownerId, boolean doesBark) implements Pet {
}
