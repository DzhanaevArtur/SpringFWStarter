package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 * @description ПсевдоБД
 */
@Slf4j
@Component
public class PersonDAO {


    /** Глобальное подключение к БД, прописанное в конфигурации */
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    @Contract(pure = true)
    public PersonDAO(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    /** Список всех людей из БД */
    public List<Person> index() { return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class)); }

    /** Получение человека по ID */
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person where id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    /** Добавление в БД нового человека */
    public void save(@NotNull Person person) {
        jdbcTemplate.update("INSERT INTO person VALUES(1, ?, ?, ?)",
                person.getName(),
                person.getAge(),
                person.getEmail()
        );
    }

    /** Обновление полей человека с конкретным ID */
    public void update(@NotNull Person person, int id) {
        jdbcTemplate.update("UPDATE person SET name=?, age=?, email=? WHERE id=?",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                id
        );
    }

    /** Удаление человека по ID */
    public void delete(int id) { jdbcTemplate.update("DELETE FROM person WHERE id=?", id); }
}
