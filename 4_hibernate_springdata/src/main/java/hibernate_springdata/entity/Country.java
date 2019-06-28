package hibernate_springdata.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@NamedQueries({
        @NamedQuery(name="Country.findAll", query="SELECT c FROM Country c"),
//        List<Country> countries = em.createNamedQuery("Country.findAll", Country.class).getResultList();
        @NamedQuery(name="Country.findById" , query="SELECT  c FROM Country c WHERE c.id=:id ")
})
@Getter@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @OneToMany(mappedBy="country",
            fetch=FetchType.EAGER,
            cascade = { CascadeType.REMOVE, CascadeType.PERSIST})
    private List<City> cities;

    public Country() {
    }
}
