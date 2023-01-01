package ru.Dzhanaev.SpringFWStarter.lessons.lesson9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.Dzhanaev.SpringFWStarter.lessons.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 01.01.2023
 */
@Slf4j
public class Lesson9 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("lessons/lesson9/lesson9.xml");
        c.getBean("classical9", Music.class).info();
        c.getBean("hipHop9",    Music.class).info();
        c.getBean("ossetian9",  Music.class).info();
    }
}
