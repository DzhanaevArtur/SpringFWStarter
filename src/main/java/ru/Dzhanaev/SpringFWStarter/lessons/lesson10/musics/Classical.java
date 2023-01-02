package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("classical10")
@Scope("singleton")
@PropertySource("classpath:lessons/lesson12/lesson12.properties")
public class Classical implements Music {


    private final List<Song> list = List.of(
            new Song("Injection",              "Hans Zimmer"),
            new Song("For Elise",              "Ludwig van Beethoven"),
            new Song("Eine kleine Nachtmusik", "Mozart"),
            new Song("The Four Seasons",       "Vivaldi"),
            new Song("Time",                   "Hans Zimmer")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));

//    @Value("${name}")
    private final String name = song.getName();

//    @Value("${author}")
    private final String author = song.getAuthor();

    @Override
    public String getSong() { return name; }

    @Override
    public String getAuthor() { return author; }
}
