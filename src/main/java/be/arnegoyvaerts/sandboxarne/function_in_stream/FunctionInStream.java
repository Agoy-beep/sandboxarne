package be.arnegoyvaerts.sandboxarne.function_in_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class FunctionInStream {

    private final String message;
    private final List<Person> listOfPersons;

    public FunctionInStream(String message) {
        this.message = message;
        this.listOfPersons = new ArrayList<>(List.of(new Person("Zaphod"), new Person("Marvin"), new Person("Arthur")));
    }

    private void addPerson(Person personToBeAdded){
        listOfPersons.add(personToBeAdded);
    }

    private Optional<String> streamListOfPersonsIntoAMessage(Function<Person, String> messageCustom){
        return listOfPersons.stream()
                .map(messageCustom)
                .findFirst();
    }

    public static void main(String[] args) {
        FunctionInStream draft = new FunctionInStream("Bleep");

        System.out.println(draft.streamListOfPersonsIntoAMessage(person -> "Bork").get());

    }
}
