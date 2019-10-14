package be.arnegoyvaerts.sandboxarne.streams;

import rpg.enemies.Enemy;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class EntrySet {

    public final List<Person> listOfPeople;
    public final Map<UUID, String> database;

    public EntrySet(List<Person> listOfPeople) {
        this.listOfPeople = listOfPeople;
        this.database = new HashMap<>();
    }

    public UUID generateUUID(){
        return UUID.randomUUID();
    }

    public Map<UUID, String> makeHashMap(){
        Map<UUID, String> mapOfIDsAndNames = new HashMap<>();

        for(Person person: listOfPeople){
            mapOfIDsAndNames.put(generateUUID(), person.getName());
        }

        return mapOfIDsAndNames;
    }
    public List<UUID> getUUIDThroughStreams(){

        return listOfPeople.stream()
                .map(name -> generateUUID())
                .collect(Collectors.toList());
    }

    public String useAnEntryMap(){
        return listOfPeople.stream()
                .map(Person::getName)
                .collect(groupingBy(getName -> getName, counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", "));

    }

    public String useAnEntryMapAlternate(){
        return listOfPeople.stream()
                .collect(groupingBy(Person::getUUID, mapping(Person::getName, joining(", ", "[", "]"))))
                .entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", "));
    }

    public Map<UUID, String> getHashMapOfUUIDAndStringThroughStreams(){

        return listOfPeople.stream()
                .collect(toMap(Person::getUUID, Person::getName));
    }

    public Map<UUID, String> getHashmapWithUUIDAndStringThroughStreamsAlternate(){
        return listOfPeople.stream()
                .collect(groupingBy(Person::getUUID, mapping(Person::getName, joining(", ", "[", "]"))));
    }

    public static void main(String[] args) {

        EntrySet set = new EntrySet(List.of(new Person("Bob"), new Person("Phil")));

        System.out.println(set.makeHashMap());
        System.out.println(set.getUUIDThroughStreams());
        System.out.println(set.getHashMapOfUUIDAndStringThroughStreams());
        System.out.println(set.useAnEntryMap());
        System.out.println(set.useAnEntryMapAlternate());
        System.out.println(set.getHashmapWithUUIDAndStringThroughStreamsAlternate());

    }
}
