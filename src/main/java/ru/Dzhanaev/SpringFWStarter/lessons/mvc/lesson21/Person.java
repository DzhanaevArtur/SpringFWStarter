package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 */
@Slf4j
@Getter
public class Person {


    private final String name;
    private final int id;


    @Contract(pure = true)
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
