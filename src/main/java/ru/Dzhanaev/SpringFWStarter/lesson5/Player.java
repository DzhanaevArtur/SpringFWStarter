package ru.Dzhanaev.SpringFWStarter.lesson5;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import ru.Dzhanaev.SpringFWStarter.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Player {


    private final Music music;


    @Contract(pure = true) public Player(Music music) { this.music = music; }

    void play() { log.info("Song name: {}\t\t Song author: {}", music.getSong(), music.getAuthor()); }
}
