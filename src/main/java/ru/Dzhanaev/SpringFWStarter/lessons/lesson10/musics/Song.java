package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
@Getter
@Setter
public class Song {

    private final String name;
    private final String author;

    @Contract(pure = true)
    public Song(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
