package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 * @description Представление человека в виде объектной модели
 */
@Slf4j
@Getter
@Setter
public class Person {


    private String name;
    private int id;


    @Contract(pure = true)
    public Person() { }

    @Contract(pure = true)
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
