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
@RequestMapping(value = "/gio", method = RequestMethod.GET)
public class Gio {


    @GetMapping("/pika")
    public String getGioPika() { return "gioPika"; }


    @GetMapping("/r")
    public String getGioR() { return "gioR"; }
}
