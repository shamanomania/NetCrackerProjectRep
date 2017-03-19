package netcracker.domain.entities;

import javax.persistence.*;

//TODO: Тестовая сущность, создавалась в качестве примера при создании структуры проекта. Подлежит удалению.
//оно запускалось с этими ошибками!
//так ты же варку деплоить хочешь

//..там другой принцип подтягивания либ
@Entity
@Table (name = "USER_TEST")
public class UserTest {

    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column (name = "NAME")
    private String name;

    public UserTest() {}

    public UserTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
