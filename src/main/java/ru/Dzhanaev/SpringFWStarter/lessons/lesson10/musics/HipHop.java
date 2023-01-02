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
@Component("hipHop10")
public class HipHop implements Music {


    private final List<Song> list = List.of(
            new Song("HipHopName1", "HipHopAuthor1"),
            new Song("HipHopName2", "HipHopAuthor2"),
            new Song("HipHopName3", "HipHopAuthor3"),
            new Song("HipHopName4", "HipHopAuthor4"),
            new Song("HipHopName5", "HipHopAuthor5")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));


    @Override
    public String getSong() { return song.getName(); }

    @Override
    public String getAuthor() { return song.getAuthor(); }
}
