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
import java.util.Optional;

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
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    /** Получение человека по ID */
    public Person show(int id) {
        return jdbcTemplate
                .query("SELECT * FROM Person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream()
                .findAny()
                .orElse(null);
    }

    /** Получение сведений для PersonValidator о дублированной почте человека в БД */
    public Optional<Person> show(String s) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email=?", new BeanPropertyRowMapper<>(Person.class), s)
                .stream().findAny();
    }

    /** Добавление в БД нового человека */
    public void save(@NotNull Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, age, email, address) VALUES(?, ?, ?, ?)",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getAddress()
        );
    }

    /** Обновление полей человека с конкретным ID */
    public void update(@NotNull Person person, int id) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=?, address=? WHERE id=?",
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getAddress(),
                id
        );
    }

    /** Удаление человека по ID */
    public void delete(int id) { jdbcTemplate.update("DELETE FROM Person WHERE id=?", id); }

    /** Удаление всех людей */
    public void deleteAll() { jdbcTemplate.update("DELETE FROM Person WHERE TRUE"); }

    /** Многократная отправка запроса */
    public void testMultipleUpdate() {
        long l = System.currentTimeMillis();
        for (Person person : create1000People()) {
            jdbcTemplate.update("INSERT INTO Person(name, age, email, address) VALUES(?, ?, ?, ?)",
                    person.getId(),
                    person.getName(),
                    person.getAge(),
                    person.getEmail(),
                    person.getAddress()
            );
        }
        log.warn("Multiple time {}", System.currentTimeMillis() - l);
    }

    /** Однократная отправка запроса */
    public void testBatchUpdate() {
        long l = System.currentTimeMillis();
        List<Person> people = create1000People();
        jdbcTemplate.batchUpdate("INSERT INTO Person(name, age, email, address) VALUES(?, ?, ?, ?)",
                new BatchPreparedStatementSetter() {

            @Override public void setValues(@NotNull PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, people.get(i).getName());
                ps.setInt   (2, people.get(i).getId());
                ps.setString(3, people.get(i).getEmail());
                ps.setString(4, people.get(i).getAddress());
            }
            @Override public int getBatchSize() { return people.size(); }
        });
        log.warn("Batch time {}", System.currentTimeMillis() - l);
    }

    private @NotNull List<Person> create1000People() {
        List<Person> list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            list.add(new Person(i, "x" + i, i, i + "@xx.ru", "Country, City, 123456"));
        }
        return list;
    }
}
