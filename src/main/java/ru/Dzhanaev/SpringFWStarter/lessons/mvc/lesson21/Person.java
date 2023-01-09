package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import jakarta.validation.constraints.*;
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


    /** Инкрементирующий идентификатор */
    private int id;

    /** Имя */
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 10, message = "Length cannot be lower then 2 & over then 30")
    private String name;

    /** Возраст */
    @Min(value = 1  , message = "Age must be over zero")
    @Max(value = 100, message = "Age cannot be over 100")
    private int age;

    /** Почтовый адрес */
    @Email(message = "Email must contain @")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 7, max = 77, message = "Length cannot be lower then 7 & over then 77")
    private String email;


    @Contract(pure = true)
    public Person() { }

    @Contract(pure = true)
    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
