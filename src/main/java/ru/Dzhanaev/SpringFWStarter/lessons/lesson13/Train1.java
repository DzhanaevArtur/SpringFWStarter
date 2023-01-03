package ru.Dzhanaev.SpringFWStarter.lessons.lesson13;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 03.01.2023
 */
@Slf4j
public class Train1 implements Train {


    @Override public String name() { return getClass().getSimpleName(); }

    @Override public int id() { return new Random().nextInt(500); }
}
