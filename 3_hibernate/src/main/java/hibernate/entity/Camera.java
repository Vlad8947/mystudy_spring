package hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cameras")
@Getter@Setter
public class Camera extends AbstractEntity {

    @Column
    @Size(min = 2, max = 21, message = "String is not valid")
    private String name;

    @Column(name="published_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate;

    public Camera() {
    }
}
