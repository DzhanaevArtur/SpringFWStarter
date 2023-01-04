package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
public class Lesson13 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(Lesson13Config.class);
        log.info(c.getBean(Lesson13Config.class).computer().toString());
        c.close();
    }
}
