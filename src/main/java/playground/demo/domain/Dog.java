package playground.demo.domain;

public record Dog(String id,
                  String name,
                  String color,
                  boolean barks) implements Pet {
}
