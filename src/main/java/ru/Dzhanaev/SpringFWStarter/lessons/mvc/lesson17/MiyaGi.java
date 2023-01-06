package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson17;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Artur Dzhanaev
 * @created 05.01.2023
 */
@Slf4j
@Controller
@RequestMapping(value = "/miyagi", method = RequestMethod.GET)
public class MiyaGi {


    @GetMapping("/colors")
    public String getColors(
            @RequestParam(value = "a", required = false) String a,
            @RequestParam(value = "b", required = false) String b
    ) {
        if (a != null && b != null) log.info(a + "\t\t" + b);
        return "/html/lesson17Colors";
    }


    @GetMapping("/tantra")
    public String getTantra(
            @RequestParam(value = "a", required = false) String a,
            @RequestParam(value = "b", required = false) String b
    ) {
        if (a != null && b != null) log.info(a + "\t\t" + b);
        return "/html/lesson17Tantra";
    }

    @GetMapping("/try")
    public String getTry(
            @RequestParam(value = "a", required = false) String a,
            @RequestParam(value = "b", required = false) String b
    ) {
        if (a != null && b != null) log.info(a + "\t\t" + b);
        return "/html/lesson17Try";
    }
}
