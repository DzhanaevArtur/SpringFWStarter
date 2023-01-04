package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
public class Computer {


    private final Player player;


    @Contract(pure = true)
    public Computer(Player player) { this.player = player; }

    @Override
    public String toString() {
        return "\nComputer {" + "\n\tplayer = " + player.play(new Random().nextInt(3)) + "\n}";
    }
}
