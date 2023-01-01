package ru.Dzhanaev.SpringFWStarter.lessons.common;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class HipHop implements Music {


    /** Приватный конструктор для фабрики */
    @Contract(pure = true) private HipHop() { }

    /** Реализация паттерна фабрика */
    @NotNull @Contract(pure = true) public static HipHop getInstance() { log.info("Fabric work"); return new HipHop(); }

    @Override public String getSong() { return "Coliseum"; }

    @Override public String getAuthor() { return "MiyaGi & Andy Panda"; }

    @Override public void init() { Music.super.init(); }

    @Override public void destroy() { Music.super.destroy(); }
}
