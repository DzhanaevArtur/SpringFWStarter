package ru.Dzhanaev.SpringFWStarter.lessons.lesson4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.Dzhanaev.SpringFWStarter.lessons.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Lesson4 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("lessons/lesson4/lesson4.xml");
        new Player(classPathXmlApplicationContext.getBean("classical4", Music.class)).play();
        new Player(classPathXmlApplicationContext.getBean("hipHop4",    Music.class)).play();
        new Player(classPathXmlApplicationContext.getBean("ossetian4",  Music.class)).play();
        classPathXmlApplicationContext.close();
    }
}
