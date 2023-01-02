package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.Song;

import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("classical10")
public class Classical implements Music {


    private final List<Song> list = List.of(
            new Song("Injection",              "Hans Zimmer"),
            new Song("For Elise",              "Ludwig van Beethoven"),
            new Song("Eine kleine Nachtmusik", "Mozart"),
            new Song("The Four Seasons",       "Vivaldi"),
            new Song("Time",                   "Hans Zimmer")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));


    @Override
    public String getSong() { return song.getName(); }

    @Override
    public String getAuthor() { return song.getAuthor(); }
}
