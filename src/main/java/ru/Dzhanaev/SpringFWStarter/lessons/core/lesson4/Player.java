package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson4;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import ru.Dzhanaev.SpringFWStarter.lessons.core.common.Music;

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
