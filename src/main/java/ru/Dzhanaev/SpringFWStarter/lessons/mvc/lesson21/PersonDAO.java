package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 * @description БД
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
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    /** Получение человека по ID */
    public Person show(int id) {
        return jdbcTemplate
                .query("SELECT * FROM person where id=?", new BeanPropertyRowMapper<>(Person.class), id)
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

    /** Многократная отправка запроса */
    public void testMultipleUpdate() {
        long l = System.currentTimeMillis();
        for (Person person : create1000People()) jdbcTemplate.update("INSERT INTO person VALUES(?, ?, ?, ?)",
                person.getId(), person.getName(), person.getAge(), person.getEmail());
        log.warn("Multiple time {}", System.currentTimeMillis() - l);
    }

    /** Однократная отправка запроса */
    public void testBatchUpdate() {
        long l = System.currentTimeMillis();
        List<Person> people = create1000People();
        jdbcTemplate.batchUpdate("INSERT INTO person VALUES(?, ?, ?, ?)", new BatchPreparedStatementSetter() {

            @Override public void setValues(@NotNull PreparedStatement ps, int i) throws SQLException {
                ps.setInt   (1, people.get(i).getId());
                ps.setString(2, people.get(i).getName());
                ps.setInt   (3, people.get(i).getId());
                ps.setString(4, people.get(i).getEmail());
            }
            @Override public int getBatchSize() { return people.size(); }
        });
        log.warn("Batch time {}", System.currentTimeMillis() - l);
    }

    private @NotNull List<Person> create1000People() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) list.add(new Person(i, "xx" + i, i % 31, "test" + i + "@xx.ru"));
        return list;
    }
}
