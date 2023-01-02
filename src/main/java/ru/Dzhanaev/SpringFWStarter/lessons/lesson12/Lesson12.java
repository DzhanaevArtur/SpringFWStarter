package ru.Dzhanaev.SpringFWStarter.lessons.lesson12;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 02.01.2023
 */
@Slf4j
public class Lesson12 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("lessons/lesson12/lesson12.xml");
        classPathXmlApplicationContext.close();
    }
}
