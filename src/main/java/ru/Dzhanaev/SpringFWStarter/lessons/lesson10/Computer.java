package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics.Genre;

import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
@Component("computer10")
public class Computer {


    public final static int ID = new Random().nextInt(Genre.values().length);

    private final Player player;

    @Autowired()
    @Contract(pure = true)
    public Computer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "\nComputer {" + "\n\tid = " + ID + ",\n\tplayer = " + player.play(Genre.values()[ID]) + "\n}";
    }
}
