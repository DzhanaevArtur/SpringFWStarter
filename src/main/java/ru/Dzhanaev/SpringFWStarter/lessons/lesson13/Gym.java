package ru.Dzhanaev.SpringFWStarter.lessons.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;

/**
 * @author Artur Dzhanaev
 * @created 03.01.2023
 */
@Slf4j
public class Gym {


    private final Train train;

    @Contract(pure = true)
    public Gym(Train train) { this.train = train; gymInfo();}

    void gymInfo() { log.info(getClass().getSimpleName() + "\t\t" + this.train.name() + "\t\t" + this.train.id()); }
}
