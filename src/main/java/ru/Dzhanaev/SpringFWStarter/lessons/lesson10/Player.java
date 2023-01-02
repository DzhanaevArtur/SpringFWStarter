package ru.Dzhanaev.SpringFWStarter.lessons.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Artur Dzhanaev
 * @created 01.01.2023
 */
@Slf4j
@Component ("player10")
public class Player {


    private final Classical classical;
    private final HipHop hipHop;
    private final Ossetian ossetian;

    @Autowired
    @Contract(pure = true)
    public Player(
            @Qualifier("classical10") Classical classical,
            @Qualifier("hipHop10") HipHop hipHop,
            @Qualifier("ossetian10") Ossetian ossetian
    ) {
        this.classical = classical;
        this.hipHop = hipHop;
        this.ossetian = ossetian;
    }

    public String play() {
        return String.format("{\n\t\tClassical song name: %s\tSong author: %s\t\t\t\tWith volume: %d" +
                        "\n\t\tHipHop song name: %s\t\tSong author: %s\t\t\t\tWith volume: %d" +
                        "\n\t\tOssetian song name: %s\t\tSong author: %s\t\tWith volume: %d\n\t}",
                classical.getSong(), classical.getAuthor(), new Random().nextInt(100),
                hipHop.getSong(), hipHop.getAuthor(), new Random().nextInt(100),
                ossetian.getSong(), ossetian.getAuthor(), new Random().nextInt(100));
    }
}
