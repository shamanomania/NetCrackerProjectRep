package netcracker.domain.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Sid775 on 09.02.2017.
 */
@Embeddable
public class PersonTestId implements Serializable {
    private Long person_id;
    private Long test_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonTestId that = (PersonTestId) o;

        if (person_id != null ? !person_id.equals(that.person_id) : that.person_id != null) return false;
        return test_id != null ? test_id.equals(that.test_id) : that.test_id == null;
    }

    @Override
    public int hashCode() {
        int result = person_id != null ? person_id.hashCode() : 0;
        result = 31 * result + (test_id != null ? test_id.hashCode() : 0);
        return result;
    }
}
