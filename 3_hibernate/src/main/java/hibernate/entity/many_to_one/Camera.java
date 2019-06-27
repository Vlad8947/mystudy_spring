package hibernate.entity.many_to_one;

import hibernate.entity.AbstractEntity;

import javax.persistence.*;

@Entity
public class Camera extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "roll_id")
    private Roll roll;

    public Camera() {
    }
}
