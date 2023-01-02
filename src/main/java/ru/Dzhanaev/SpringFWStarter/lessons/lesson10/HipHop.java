package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
@Component("hipHop10")
public class HipHop implements Music {


    @Override
    public String getSong() { return "Coliseum"; }

    @Override
    public String getAuthor() { return "MiyaGi & Andy Panda"; }
}
