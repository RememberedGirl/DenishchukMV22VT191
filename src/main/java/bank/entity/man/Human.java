package bank.entity.man;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// Human - объект человек, содержит поля:
// id человека, имя, фамилия, отчество, дата рождения.
@Setter
@Getter
public class Human {
    private Integer id;
    private String name;
    private String surname;
    private String middleName = null;
    private LocalDate birthDay;

    public Human(Integer id, String name, String surname, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
    }

    public Human(Integer id, String name, String surname, String middleName, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.birthDay = birthDay;
    }

    public String getFullName() {
        if (middleName != null)
            return name + " " + surname + " " + middleName;
        else
            return name + " " + surname;
    }
}
