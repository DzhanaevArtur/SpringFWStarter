package ru.Dzhanaev.SpringFWStarter.lessons.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Music {


    Logger log = LoggerFactory.getLogger(Music.class);


    String getSong();

    String getAuthor();

    default void init() { log.info("{} init work", getClass().getSimpleName()); }

    default void destroy() { log.info("{} destroy work", getClass().getSimpleName()); }

    default void info() { log.info("Song {} with author {}", getSong(), getAuthor()); }
}
