package hibernate.entity.many_to_many;

import hibernate.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
//@Table(name = "roll")
@Getter@Setter
public class Roll extends AbstractEntity {

    @ManyToMany(mappedBy = "roll")
    private List<Camera> cameras;

    public Roll() {
    }
}
