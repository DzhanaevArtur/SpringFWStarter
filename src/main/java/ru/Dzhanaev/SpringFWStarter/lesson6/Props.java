package ru.Dzhanaev.SpringFWStarter.lesson6;

import lombok.extern.slf4j.Slf4j;
import ru.Dzhanaev.SpringFWStarter.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 31.12.2022
 */
@Slf4j
public class Props implements Music {


    @Override public String getSong() { return "SomeImportantSong"; }

    @Override public String getAuthor() { return "SomeImportantDick"; }
}
