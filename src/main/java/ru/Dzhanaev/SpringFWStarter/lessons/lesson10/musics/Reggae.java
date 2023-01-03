package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 03.01.2023
 */
@Slf4j
public class Reggae implements Music {


    private final List<Song> list = List.of(
            new Song("No Woman No Cry", "Bob Marley"),
            new Song("Sun Is Shining",  "Bob Marley"),
            new Song("Is This Love",    "Bob Marley"),
            new Song("Get Up Stand Up", "Bob Marley"),
            new Song("Buffalo Soldier", "Bob Marley")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));

    private final String name = song.getName();

    private final String author = song.getAuthor();

    @Override
    public String getSong() { return name; }

    @Override
    public String getAuthor() { return author; }

    @PostConstruct
    private void analogueOfInit() { log.info("Inside reggae init"); }

    @PreDestroy
    private void analogueOfDestroy() { log.info("Inside reggae Destroy"); }
}
