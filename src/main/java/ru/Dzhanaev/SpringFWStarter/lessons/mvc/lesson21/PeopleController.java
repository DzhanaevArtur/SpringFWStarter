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


    /** ПсевдоБД */
    private final PersonDAO personDAO;


    @Contract(pure = true)
    public PeopleController(PersonDAO personDAO) { this.personDAO = personDAO; }

    /**
     * Отображение списка всех людей из "БД"
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     */
    @GetMapping()
    public String index(@NotNull Model model) {
        model.addAttribute("people", personDAO.getList());
        return "/html/lesson21PeopleIndex";
    }

    /**
     * Отображение конкретного человека по указанному id: /people/id
     * @param id Идентификатор человека
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, @NotNull Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson21PeopleShow";
    }

    /**
     * @param person Создаваемый человек
     * @return Отображение формы добавления человека в псевдоБД
     */
    @GetMapping("/new")
    public String newPerson(@ModelAttribute Person person) { return "/html/lesson22New"; }

    /**
     * Обработка добавленного человека и последующее представление всех людей из БД
     * @param person Созданный человек
     * @return Обновлённый список людей из БД
     */
    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
