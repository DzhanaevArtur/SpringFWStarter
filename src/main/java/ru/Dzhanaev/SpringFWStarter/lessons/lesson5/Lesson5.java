package ru.Dzhanaev.SpringFWStarter.lessons.lesson5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.Dzhanaev.SpringFWStarter.lessons.common.Music;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Lesson5 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("lessons/lesson5/lesson5.xml");
        Music classical = classPathXmlApplicationContext.getBean("classical5", Music.class);
        Music hipHop = classPathXmlApplicationContext.getBean("hipHop5", Music.class);
        Music ossetian = classPathXmlApplicationContext.getBean("ossetian5", Music.class);
        log.info("Song name: {}\t\t Song author: {}", classical.getSong(), classical.getAuthor());
        log.info("Song name: {}\t\t Song author: {}", hipHop.getSong(), hipHop.getAuthor());
        log.info("Song name: {}\t\t Song author: {}", ossetian.getSong(), ossetian.getAuthor());
        classPathXmlApplicationContext.close();
    }
}
