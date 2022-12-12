package bank.entity.man;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


// id человека, имя, фамилия, отчество, дата рождения.
@Setter
@Getter
/**
 * Human - объект человек
 */
public class Human {
    /**
     * Id человека
     */
    private Integer id;

    /**
     * Имя человека
     */
    private String name;

    /**
     * Фамилия человека
     */
    private String surname;

    /**
     * Отчество человека
     */
    private String middleName = null;

    /**
     * Дата рождения человека
     */
    private LocalDate birthDay;

    /**\
     * Конструктор Human (Без Отчества)
     * @param id
     * @param name
     * @param surname
     * @param birthDay
     */
    public Human(Integer id, String name, String surname, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    /**
     * Конструктор Human
     * @param id
     * @param name
     * @param surname
     * @param middleName
     * @param birthDay
     */
    public Human(Integer id, String name, String surname, String middleName, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthDay = birthDay;
    }

    /**
     * Выводим полное имя человека (его ФИО)
     * @return
     */
    public String getFullName() {
        if (middleName != null)
            return name + " " + surname + " " + middleName;
        else
            return name + " " + surname;
    }
}
