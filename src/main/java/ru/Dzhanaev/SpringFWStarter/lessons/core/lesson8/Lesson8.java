package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.Dzhanaev.SpringFWStarter.lessons.core.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 31.12.2022
 */
@Slf4j
public class Lesson8 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("lessons/core/lesson8/lesson8.xml");

        log.info(c.getBean("classical8", Music.class).getAuthor());
        log.info(c.getBean("hipHop8",    Music.class).getAuthor());
        log.info(c.getBean("ossetian8",  Music.class).getAuthor());

        c.close();
    }
}
