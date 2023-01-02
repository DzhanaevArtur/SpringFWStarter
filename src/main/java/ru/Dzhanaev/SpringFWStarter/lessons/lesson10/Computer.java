package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
@Component("computer10")
public class Computer {


    private final int id;

    private final Player player;

    @Autowired()
    @Contract(pure = true)
    public Computer(Player player) {
        this.id = 69;
        this.player = player;
    }

    @Override
    public String toString() { return "\nComputer {" + "\n\tid = " + id + ",\n\tplayer = " + player.play() + "\n}"; }
}
