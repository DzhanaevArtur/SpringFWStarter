package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson6;

import lombok.extern.slf4j.Slf4j;
import ru.Dzhanaev.SpringFWStarter.lessons.core.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 31.12.2022
 */
@Slf4j
public class PropsMusic implements Music {


    @Override public String getSong() { return "SomeImportantSong"; }

    @Override public String getAuthor() { return "SomeImportantDick"; }
}
