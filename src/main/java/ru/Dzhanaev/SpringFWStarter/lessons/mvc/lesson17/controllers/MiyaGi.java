package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson17.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Artur Dzhanaev
 * @created 05.01.2023
 */
@Slf4j
@Controller
@RequestMapping(value = "/miyagi", method = RequestMethod.GET)
public class MiyaGi {


    @GetMapping("/try")
    public String getTry() { return "lesson17/Try"; }


    @GetMapping("/tantra")
    public String getTantra() { return "lesson17/Tantra"; }
}
