package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson15;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Artur Dzhanaev
 * @created 04.01.2023
 */
@Slf4j
@Controller
public class Hello {


    @GetMapping("/firstTry")
    public String writeHello() { return "firstTry"; }


    @GetMapping("/second")
    public String secondTry() { return "second"; }
}
