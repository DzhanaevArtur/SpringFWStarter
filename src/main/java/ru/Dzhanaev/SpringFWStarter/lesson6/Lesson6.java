package ru.Dzhanaev.SpringFWStarter.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Lesson6 {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("lesson6/applicationContext6.xml");

        classPathXmlApplicationContext.getBean("playerClassical6", Player.class).play();
        classPathXmlApplicationContext.getBean("playerHipHop6",    Player.class).play();
        classPathXmlApplicationContext.getBean("playerOssetian6",  Player.class).play();
        classPathXmlApplicationContext.getBean("playerProps6",     Player.class).play();
        classPathXmlApplicationContext.getBean("playerList6",      Player.class).playList();

        classPathXmlApplicationContext.close();
    }
}
