package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.Song;

import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
@Component("pop10")
public class Pop implements Music {


    private final List<Song> list = List.of(
            new Song("Tantra",   "MiyaGi & Andy Panda"),
            new Song("Atlant",   "MiyaGi & Andy Panda"),
            new Song("Utopia",   "MiyaGi & Andy Panda"),
            new Song("Minor",    "MiyaGi & Andy Panda"),
            new Song("Medicine", "MiyaGi & Andy Panda")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));


    @Override
    public String getSong() { return song.getName(); }

    @Override
    public String getAuthor() { return song.getAuthor(); }
}
