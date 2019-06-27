package hibernate.entity.one_to_one;

import hibernate.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "roll")
@Getter@Setter
public class Roll extends AbstractEntity {

    @OneToOne(mappedBy = "roll")
    private Camera camera;

    public Roll() {
    }
}
