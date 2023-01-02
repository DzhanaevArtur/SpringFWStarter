package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("classical10")
public class Classical implements Music {


    @Override
    public String getSong() { return "For Elise"; }

    @Override
    public String getAuthor() { return "Ludwig van Beethoven"; }
}
