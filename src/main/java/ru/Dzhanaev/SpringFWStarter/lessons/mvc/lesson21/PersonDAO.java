package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Dzhanaev
 * @created 07.01.2023
 * @description ПсевдоБД
 */
@Slf4j
@Component
public class PersonDAO {


    /** Ссылка для подключения к БД */
    private final static String URL = "jdbc:postgresql://localhost:5432/first_db";

    /** Имя пользователя БД */
    private final static String username = "postgres";

    /** Пароль от БД */
    private final static String password = "blockPost";

    /** Подключение к БД */
    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        }
        catch (SQLException | ClassNotFoundException e) { throw new RuntimeException(e); }
    }


    /** Список всех людей из БД */
    public List<Person> index() {
        List<Person> list = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                list.add(new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("email")
                ));
            }
        }
        catch (SQLException e) { throw new RuntimeException(e); }
        return list;
    }

    /** Получение человека по ID */
    public Person show(int id) { return index().stream().filter(x -> x.getId() == id).findAny().orElse(null); }

    /** Добавление в БД нового человека */
    public void save(@NotNull Person person) {
        try {
            connection.createStatement().executeUpdate("INSERT INTO person VALUES(" +
                    1 + ", '" + person.getName() + "', " + person.getAge() + ", '" + person.getEmail() + "')");
        }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    /** Обновление полей человека с конкретным ID */
    public void update(@NotNull Person person, int id) {
        person.setId(id);
    }

    /** Удаление человека по ID */
    public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(String.format("DELETE FROM person WHERE id = %d", id));
        }
        catch (SQLException e) { throw new RuntimeException(e); }
    }
}
