package hibernate.entity.one_to_one;

import hibernate.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Camera extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "roll_id")
    private Roll roll;

    public Camera() {
    }
}
