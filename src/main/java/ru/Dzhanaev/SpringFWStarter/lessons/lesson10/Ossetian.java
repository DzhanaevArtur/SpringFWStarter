package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("ossetian10")
public class Ossetian implements Music {


    @Override
    public String getSong() { return "Cecilia"; }

    @Override
    public String getAuthor() { return "Gaezdaenty Gaeppoyi fyrt Bulat"; }
}
