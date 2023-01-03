package ru.Dzhanaev.SpringFWStarter.lessons.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.Computer;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.Player;
import ru.Dzhanaev.SpringFWStarter.lessons.lesson10.musics.*;

import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Configuration()
@Slf4j
public class SpringConfig {


    @Bean
    @Scope("singleton")
    public List<Music> list(){ return List.of(new Classical(), new HipHop(), new Ossetian(), new Reggae()); }

    @Bean
    @Scope("singleton")
    public Computer computer() {
        return new Computer(new Player(list()));
    }
}

