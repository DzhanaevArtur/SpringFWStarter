package ru.Dzhanaev.SpringFWStarter.lessons.core.lesson10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 01.01.2023
 */
@Slf4j
public class Lesson10 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("lessons/core/lesson10/lesson10.xml");
        log.info(classPathXmlApplicationContext.getBean(Computer.class).toString());
        classPathXmlApplicationContext.close();
    }
}
