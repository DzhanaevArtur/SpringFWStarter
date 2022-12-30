package ru.Dzhanaev.SpringFWStarter.lesson6;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Ossetian implements Music {


    @Override public String getSong() { return "Cecilia"; }

    @Override public String getAuthor() { return "Gaezdaenty Gaeppoyi fyrt Bulat"; }
}
