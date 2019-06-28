package hibernate_springdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@Getter@Setter
public class City {

    @ManyToOne
//    @JoinColumn(name = "id")
    private Country country;

    public City() {
    }
}
