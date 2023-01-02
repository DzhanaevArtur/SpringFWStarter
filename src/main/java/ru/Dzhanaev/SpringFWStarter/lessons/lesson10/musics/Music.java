package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Music {


    Logger log = LoggerFactory.getLogger(Music.class);


    String getSong();

    String getAuthor();

    default String info() { return String.format("Song %s with author %s", getSong(), getAuthor()); }
}
