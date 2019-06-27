package hibernate.entity.many_to_many;

import hibernate.entity.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Camera extends AbstractEntity {

    @ManyToMany
    @JoinTable(name = "camera_roll",
    joinColumns = @JoinColumn(name = "camera_id"),
    inverseJoinColumns = @JoinColumn(name = "roll_id"))
    private List<Roll> rolls;

    public Camera() {
    }
}
