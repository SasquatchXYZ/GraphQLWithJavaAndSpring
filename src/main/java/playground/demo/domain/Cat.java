package playground.demo.domain;

public record Cat(String id,
                  String name,
                  String color,
                  boolean meows) implements Pet {
}
