package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 */
@Slf4j
@Controller
@RequestMapping("/people")
public class PeopleController {


    private final PersonDAO personDAO;


    @Contract(pure = true)
    public PeopleController(PersonDAO personDAO) { this.personDAO = personDAO; }

    @GetMapping()
    public String index(@NotNull Model model) {
        model.addAttribute("people", personDAO.getList());
        return "/html/lesson21PeopleIndex";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, @NotNull Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson21PeopleShow";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute Person person) {
        return "/html/lesson22New";
    }

    @PostMapping()
    public String create(@ModelAttribute Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
