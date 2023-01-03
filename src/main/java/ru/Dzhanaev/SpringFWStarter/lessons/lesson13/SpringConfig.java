package ru.Dzhanaev.SpringFWStarter.lessons.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Configuration()
@Slf4j
public class SpringConfig {


    @Bean
    public Train getTrain1() {
        return new Train1();
    }

    @Bean
    public Train getTrain2() {
        return new Train2();
    }

    @Bean
    public Gym getGym0() {
        return new Gym(getTrain2());
    }
}

