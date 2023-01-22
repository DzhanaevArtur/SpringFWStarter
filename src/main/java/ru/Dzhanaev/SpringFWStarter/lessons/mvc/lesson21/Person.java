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
    @Size(min = 2, max = 20, message = "Length cannot be lower then 2 & over then 30")
    private String name;

    /** Возраст */
    @Min(value = 1  , message = "Age must be over zero")
    @Max(value = 200, message = "Age cannot be over 666")
    private int age;

    /** Почтовый адрес */
    @Email(message = "Email must contain @")
    @NotEmpty(message = "Email cannot be empty")
    @Size(min = 7, max = 77, message = "Length cannot be lower then 7 & over then 77")
    private String email;

    /** Физический адрес */
    @NotEmpty(message = "Address cannot be empty")
    @Size(min = 1, max = 99, message = "Length cannot be lower then 1 & over then 99")
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",
            message = "Correct address should look like this: Country, City, 6-digit zip-code")
    private String address;


    @Contract(pure = true)
    public Person() { }

    @Contract(pure = true)
    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }
}
