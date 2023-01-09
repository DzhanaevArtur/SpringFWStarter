package ru.Dzhanaev.SpringFWStarter.lessons.mvc.lesson21;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

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


    /** Уникальный инкрементирующий идентификатор */
    private static int ID = 1;

    /** Список людей в БД с последующей инициализацией */
    @Getter @Setter
    private List<Person> list;


    {
        list = new ArrayList<>();
        list.add(new Person("Artur",   ID++));
        list.add(new Person("Alan",    ID++));
        list.add(new Person("Alex",    ID++));
        list.add(new Person("Timur",   ID++));
        list.add(new Person("Batradz", ID++));
        list.add(new Person("Skif",    ID++));
        list.add(new Person("Sarmat",  ID++));
    }

    /** Получение человека по ID */
    public Person show(int id) { return getList().stream().filter(x -> x.getId() == id).findAny().orElse(null); }

    /** Добавление в БД нового человека */
    public void save(@NotNull Person person) { person.setId(ID++); getList().add(person); }

    /** Обновление имени человека с конкретным ID */
    public void update(@NotNull Person person, int id) { show(id).setName(person.getName()); }

    /** Удаление человека по ID */
    public void delete(int id) { list.removeIf(x -> x.getId() == id); }
}
