package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Dzhanaev.SpringFWStarter.lessons2.lesson40.PersonValidator;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 */
@Slf4j
@Controller
@RequestMapping("/people")
public class PeopleController {


    /** БД */
    private final PersonDAO personDAO;

    /** Сущность валидации запросов в БД */
    private final PersonValidator personValidator;


    /**
     * Конструктор
     * @param personDAO экземпляр БД
     * @param personValidator валидация запросов в БД
     */
    @Contract(pure = true)
    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    /**
     * Отображение списка всех людей из БД
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     */
    @GetMapping()
    public String full(@NotNull Model model) {
        model.addAttribute("people", personDAO.index());
        return "/html/lesson21Full";
    }

    /**
     * Отображение конкретного человека по указанному id: /people/id
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     * @param id Идентификатор человека
     */
    @GetMapping("/{id}")
    public String onlyOne(@NotNull Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson21OnlyOne";
    }

    /**
     * Отображение формы добавления человека в псевдоБД
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
     * @param bindingResult обработчик ошибок, вызываемых валидацией полей модели человека
     * @return Обновлённый список людей из БД
     */
    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, @NotNull BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) return "/html/lesson22New";
        personDAO.save(person);
        return "redirect:/people";
    }

    /**
     * Редактирование конкретного человека, по указанному id
     * @param model Получение доступа к модели в контроллере, через экземпляр класса Model, который внедряет Spring,
     *               для последующей отправки этой модели на шаблонизатор для отображения
     * @param id Идентификатор человека
     * @return Страница для редактирования человека
     */
    @GetMapping("/{id}/edit")
    public String edit(@NotNull Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "/html/lesson23Edit";
    }

    /**
     * Обработка изменения полей человека с конкретным ID и последующее представление всех людей из БД
     * @param person Обновляемый человек
     * @param bindingResult обработчик ошибок, вызываемых валидацией полей модели человека
     * @param id идентификатор человека
     * @return Обновлённый список людей из БД
     */
    @PatchMapping("/{id}")
    public String update(
            @ModelAttribute("person") @Valid Person person,
            @NotNull BindingResult bindingResult,
            @PathVariable("id") int id
    ) {
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors()) return "/html/lesson23Edit";
        personDAO.update(person, id);
        return "redirect:/people";
    }

    /**
     * Удаление человека из БД
     * @param id идентификатор человека
     * @return Отображение всех людей после удаления
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

    /**
     * Удаление всех людей из БД
     * @return Отображение начальной страницы
     */
    @DeleteMapping("/delete")
    public String deleteAll() {
        personDAO.deleteAll();
        return "redirect:";
    }

    /**
     * Возврат к истокам
     * @return Отображение начальной страницы
     */
    @GetMapping("/back")
    public String commonView() { return "/html/lesson41CommonView"; }
}
