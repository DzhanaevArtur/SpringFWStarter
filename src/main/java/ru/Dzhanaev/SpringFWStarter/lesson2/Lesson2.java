package ru.Dzhanaev.SpringFWStarter.lesson2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artur Dzhanaev
 * @created 30.12.2022
 */
@Slf4j
public class Lesson2  {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("lesson2/applicationContext2.xml");
        TestBean testBean = cont.getBean("testBean", TestBean.class);
        log.info(testBean.getName());
        cont.close();
    }
}
