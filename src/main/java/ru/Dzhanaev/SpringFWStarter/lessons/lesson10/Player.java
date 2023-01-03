package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics.*;

import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 01.01.2023
 */
@Slf4j
public class Player {


    private final List<Music> list;


    @Contract(pure = true)
    public Player(List<Music> list) { this.list = list; }

    public String play(int index) { return list.get(index).info(); }
}
