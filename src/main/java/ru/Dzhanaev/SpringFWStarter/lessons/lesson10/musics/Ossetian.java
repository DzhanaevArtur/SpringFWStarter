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
@Component("ossetian10")
public class Ossetian implements Music {


    private final List<Song> list = List.of(
            new Song("Cecilia",               "Gaezdaenty Gaeppoyi fyrt Bulat"),
            new Song("Salam khaestybydyraey", "Ballaity Davivy fyrt Vladimir"),
            new Song("Iry zar",               "Taisaity Kaeidaer fyrt Oleg"),
            new Song("Simd",                  "Iron adaemon kaft"),
            new Song("Bulaemaergh",           "Suanty Semiony fyrt Kim")
    );

    private final Song song = list.get(new Random().nextInt(list.size()));


    @Override
    public String getSong() { return song.getName(); }

    @Override
    public String getAuthor() { return song.getAuthor(); }
}
