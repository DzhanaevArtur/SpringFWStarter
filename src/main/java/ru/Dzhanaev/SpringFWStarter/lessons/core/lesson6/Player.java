package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson6;

import lombok.extern.slf4j.Slf4j;
import ru.Dzhanaev.SpringFWStarter.lessons.core.common.Music;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Player {


    private List<Music> list = new ArrayList<>();

    private Music music;

    private String name;

    private int volume;


    public List<Music> getList() { return list; }

    public void setList(List<Music> list) { this.list = list; }

    public Music getMusic() { return music; }

    public void setMusic(Music music) { this.music = music; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getVolume() { return volume; }

    public void setVolume(int volume) { this.volume = volume; }

    void play() {
        log.info("Song name: {}\tSong author: {}\tPlayer vendor: {}\tWith max volume: {}dB",
                music.getSong(), music.getAuthor(), name, volume);
    }

    void playList() {
        log.info("\n");
        for (Music music : list) log.info("Song name: {}\tSong author: {}\tPlayer vendor: {}\tWith max volume: {}dB",
                music.getSong(), music.getAuthor(), name, volume);
    }
}
