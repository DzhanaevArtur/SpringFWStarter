package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics.*;

/**
 * @author Artur Dzhanaev
 * @created 01.01.2023
 */
@Slf4j
@Component ("player10")
@Scope ("singleton")
@PropertySource("classpath:lessons/lesson10/lesson10.properties")
public class Player {


    private final Classical classical;
    
    private final HipHop hipHop;
    
    private final Ossetian ossetian;
    
    @Value("${player.vendor}")
    private String vendor;


    @Value("${player.price}")
    private Integer price;


    @Autowired
    @Contract(pure = true)
    public Player(
            @Qualifier("classical10") Classical classical,
            @Qualifier("hipHop10")    HipHop hipHop,
            @Qualifier("ossetian10")  Ossetian ossetian
    ) {
        this.classical = classical;
        this.hipHop    = hipHop;
        this.ossetian  = ossetian;
    }

    public String play(@NotNull Genre genre) {
        String output;
        switch (genre) {
            case Classical -> output = classical.info();
            case HipHop -> output = hipHop.info();
            case Ossetian -> output = ossetian.info();
            default -> output = "Warning in switch-case";
        }
        return output + "\tvolume: " + 100 * Computer.ID + "\tvendor: " + vendor + "\tprice: " + price;
    }
}
