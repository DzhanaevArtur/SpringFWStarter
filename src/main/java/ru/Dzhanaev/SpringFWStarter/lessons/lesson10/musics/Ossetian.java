package ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("ossetian10")
@Scope("singleton")
@PropertySource("classpath:lessons/lesson10/lesson10.properties")
public class Ossetian implements Music {


    private final List<Song> list = List.of(
            new Song("Cecilia",               "Gaezdaenty Gaeppoyi fyrt Bulat"),
            new Song("Salam khaestybydyraey", "Ballaity Davivy fyrt Vladimir"),
            new Song("Iry zar",               "Taisaity Kaeidaer fyrt Oleg"),
            new Song("Simd",                  "Iron adaemon kaft"),
            new Song("Bulaemaergh",           "Suanty Semiony fyrt Kim")
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
