package ru.Dzhanaev.SpringFWStarter.lessons.core.common;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("classical9")
public class Classical implements Music {


    /** Приватный конструктор для фабрики */
    @Contract(pure = true) private Classical() { }

    /** Реализация паттерна фабрика */
    @NotNull @Contract(pure = true) public static Classical getInstance() { log.info("Fabric work"); return new Classical(); }

    @Override public String getSong() { return "For Elise"; }

    @Override public String getAuthor() { return "Ludwig van Beethoven"; }

    @Override public void init() { Music.super.init(); }

    @Override public void destroy() { Music.super.destroy(); }
}
