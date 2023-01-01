package ru.Dzhanaev.SpringFWStarter.lessons.common;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Ossetian implements Music {


    /** Приватный конструктор для фабрики */
    @Contract(pure = true) private Ossetian() { }

    /** Реализация паттерна фабрика */
    @NotNull @Contract(pure = true) public static Ossetian getInstance() { log.info("Fabric work"); return new Ossetian(); }

    @Override public String getSong() { return "Cecilia"; }

    @Override public String getAuthor() { return "Gaezdaenty Gaeppoyi fyrt Bulat"; }

    @Override public void init() { Music.super.init(); }

    @Override public void destroy() { Music.super.destroy(); }
}
