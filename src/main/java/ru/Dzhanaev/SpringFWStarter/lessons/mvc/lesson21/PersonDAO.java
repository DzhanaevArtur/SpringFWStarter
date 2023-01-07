package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 */
@Slf4j
@Component
public class PersonDAO {


    private static int ID = 1;

    @Getter
    private final List<Person> list = List.of(
            new Person("Artur",   ID++),
            new Person("Alan",    ID++),
            new Person("Alex",    ID++),
            new Person("Timur",   ID++),
            new Person("Batradz", ID++),
            new Person("Skif",    ID++),
            new Person("Sarmat",  ID++)
    );

    public Person show(int id) { return list.stream().filter(x -> x.getId() == id).findAny().orElse(null); }
}
