package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Music {


    Logger log = LoggerFactory.getLogger(Music.class);


    String getSong();

    String getAuthor();

    default void info() { log.info("Song {} with author {}", getSong(), getAuthor()); }
}
