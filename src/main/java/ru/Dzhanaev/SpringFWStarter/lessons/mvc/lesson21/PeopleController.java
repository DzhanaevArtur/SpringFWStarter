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


    /** Конструктор */
    @Contract(pure = true)
    public PeopleController(PersonDAO personDAO) { this.personDAO = personDAO; }

    /**
     * Отображение списка всех людей из "БД"
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     */
    @GetMapping()
    public String full(@NotNull Model model) {
        model.addAttribute("people", personDAO.getList());
        return "/html/lesson21Full";
    }

    /**
     * Отображение конкретного человека по указанному id: /people/id
     * @param id Идентификатор человека
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     */
    @GetMapping("/{id}")
    public String onlyOne(@NotNull Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson21OnlyOne";
    }

    /**
     * @param person Создаваемый человек
     * @return Отображение формы добавления человека в псевдоБД
     */
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "/html/lesson22New";
    }

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

    /**
     * Редактирование конкретного человека, по указанному id
     * @param id Идентификатор человека
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     * @return Страница для редактирования человека
     */
    @GetMapping("/{id}/edit")
    public String edit(@NotNull Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson23Edit";
    }

    /**
     * Обработка изменения имени человека и последующее представление всех людей из БД
     * @param person Отредактированный человек
     * @return Обновлённый список людей из БД
     */
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
