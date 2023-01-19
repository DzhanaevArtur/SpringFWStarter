package ru.Dzhanaev.SpringFWStarter.lessons2.lesson29;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21.PersonDAO;

/**
 * @author Artur Dzhanaev
 * @created 19.01.2023
 */
@Slf4j
@Controller
@RequestMapping("/test-batch-update")
public class BatchController {


    private final PersonDAO personDAO;


    @Contract(pure = true)
    @Autowired
    public BatchController(PersonDAO personDAO) { this.personDAO = personDAO; }

    @GetMapping()
    public String index() { return "/html/lesson29BatchIndex"; }

    @GetMapping("/without")
    public String withoutBatch() { personDAO.testMultipleUpdate(); return "redirect:/people"; }

    @GetMapping("/with")
    public String withBatch() { personDAO.testBatchUpdate(); return "redirect:/people"; }

}
