package ru.Dzhanaev.SpringFWStarter.lessons.lesson13;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
public class Lesson13 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringConfig springConfig = c.getBean(SpringConfig.class);
        springConfig.getGym0();
        c.close();
    }
}
