package hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cameras")
@Getter@Setter
public class Camera extends AbstractEntity {

    @Column
    private String name;

    public Camera() {
    }
}
