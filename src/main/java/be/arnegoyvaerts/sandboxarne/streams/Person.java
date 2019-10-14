package be.arnegoyvaerts.sandboxarne.streams;

import java.util.UUID;

public class Person {

    private final String name;
    private UUID id;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUUID(){
        return UUID.randomUUID();
    }
}
