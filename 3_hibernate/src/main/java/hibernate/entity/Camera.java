package hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cameras")
@Getter@Setter
public class Camera extends AbstractEntity {

    @Column
    private String name;

    @Column(name="published_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;

    public Camera() {
    }
}
