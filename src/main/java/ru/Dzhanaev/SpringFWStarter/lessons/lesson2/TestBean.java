package ru.Dzhanaev.SpringFWStarter.lessons.lesson2;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Getter
@Setter
public class TestBean {


    private String name;

    @Contract(pure = true) public TestBean(String name) { this.name = name; }
}
