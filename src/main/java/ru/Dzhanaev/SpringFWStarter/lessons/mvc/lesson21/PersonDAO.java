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
    public Person show(int id) {
        Person person;
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * FROM person where id=?");
            p.setInt(1, id);
            ResultSet resultSet = p.executeQuery();
            resultSet.next();

            person = new Person();
            person.setId   (resultSet.getInt   ("id"));
            person.setName (resultSet.getString("name"));
            person.setAge  (resultSet.getInt   ("age"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException e) { throw new RuntimeException(e); }
        return person;
    }

    /** Добавление в БД нового человека */
    public void save(@NotNull Person person) {
        try {
            PreparedStatement p = connection.prepareStatement("INSERT INTO person VALUES(1, ?, ?, ?)");

            p.setString(1, person.getName());
            p.setInt   (2, person.getAge());
            p.setString(3, person.getEmail());
            p.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    /** Обновление полей человека с конкретным ID */
    public void update(@NotNull Person person, int id) {
        try {
            PreparedStatement p = connection.prepareStatement("UPDATE person SET name=?, age=?, email=? WHERE id=?");
            p.setString(1, person.getName());
            p.setInt   (2, person.getAge());
            p.setString(3, person.getEmail());
            p.setInt   (4, id);
            p.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }

    /** Удаление человека по ID */
    public void delete(int id) {
        try {
            PreparedStatement p = connection.prepareStatement("DELETE FROM person WHERE id=?");
            p.setInt(1, id);
            p.executeUpdate();
        } catch (SQLException e) { throw new RuntimeException(e); }
    }
}
