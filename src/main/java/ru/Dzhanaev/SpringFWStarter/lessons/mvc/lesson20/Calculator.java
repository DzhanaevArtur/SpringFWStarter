package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson20;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 */
@Slf4j
@Controller
public class Calculator {


    @GetMapping("/calculator")
    public String getColors(
            @RequestParam(value = "a", required = false) int a,
            @RequestParam(value = "b", required = false) int b,
            @RequestParam(value = "op", required = false) @NotNull String op,
            Model m
    ) {
        int output;
        if (op.equals(String.valueOf(Operation.MUL))) output = a * b;
        else if (op.equals(String.valueOf(Operation.ADD))) output = a + b;
        else if (op.equals(String.valueOf(Operation.SUB))) output = a - b;
        else output = a / b;
        m.addAttribute("output", output);
        return "/html/lesson20Calculator";
    }
}
