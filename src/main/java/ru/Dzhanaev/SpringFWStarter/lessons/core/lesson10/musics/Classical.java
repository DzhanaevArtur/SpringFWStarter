package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson10.musics;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Classical implements Music {


    private final List<Song> list = List.of(
            new Song("Injection",              "Hans Zimmer"),
            new Song("For Elise",              "Ludwig van Beethoven"),
            new Song("Eine kleine Nachtmusik", "Mozart"),
            new Song("The Four Seasons",       "Vivaldi"),
            new Song("Time",                   "Hans Zimmer")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));

    private final String name = song.getName();

    private final String author = song.getAuthor();

    @Override
    public String getSong() { return name; }

    @Override
    public String getAuthor() { return author; }

    @PostConstruct
    private void analogueOfInit() { log.info("Inside classical init"); }

    @PreDestroy
    private void analogueOfDestroy() { log.info("Inside classical Destroy"); }
}
