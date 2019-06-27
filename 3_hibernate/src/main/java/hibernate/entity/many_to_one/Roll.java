package hibernate.entity.many_to_one;

import hibernate.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
//@Table(name = "roll")
@Getter@Setter
public class Roll extends AbstractEntity {

    @OneToMany(mappedBy = "roll")
    private List<Camera> cameras;

    public Roll() {
    }
}
