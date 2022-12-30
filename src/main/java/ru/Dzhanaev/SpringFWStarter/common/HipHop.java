package ru.Dzhanaev.SpringFWStarter.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class HipHop implements Music {


    @Override public String getSong() { return "Coliseum"; }

    @Override public String getAuthor() { return "MiyaGi & Andy Panda"; }
}
