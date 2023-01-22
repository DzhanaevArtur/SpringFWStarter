package ru.Dzhanaev.SpringFWStarter.lessons2.lesson40;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21.Person;
import ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21.PersonDAO;

/**
 * @author Artur Dzhanaev
 * @created 22.01.2023
 */
@Slf4j
@Component
public class PersonValidator implements Validator {


    private final PersonDAO personDAO;


    @Contract(pure = true)
    @Autowired
    public PersonValidator(PersonDAO personDAO) { this.personDAO = personDAO; }

    @Override
    public boolean supports(@NotNull Class<?> clazz) { return clazz.equals(Person.class); }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        if (personDAO.show(((Person) target).getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already in use");
        }
    }
}
