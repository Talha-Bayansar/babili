package be.thomasmore.babili.model;

import io.micrometer.shaded.org.pcollections.PCollection;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Cursus {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cursus_generator")
    @SequenceGenerator(name = "cursus_generator", sequenceName = "cursus_seq",
            initialValue = 0, allocationSize = 1)
    @Id
    private Integer id;
    private String naam;
    private String beschrijving;
    @ManyToOne(fetch = FetchType.LAZY)
    private User docent;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursus")
    private Collection<User> cursisten;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cursus")
    private Collection<Opdracht> opdrachten;


    public Cursus() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public User getDocent() {
        return docent;
    }

    public void setDocent(User userDocent) {
        this.docent = userDocent;
    }

    public Collection<User> getCursisten() {
        return cursisten;
    }

    public void setCursisten(Collection<User> cursisten) {
        this.cursisten = cursisten;
    }

    public Collection<Opdracht> getOpdrachten() {
        return opdrachten;
    }

    public void setOpdrachten(Collection<Opdracht> opdrachten) {
        this.opdrachten = opdrachten;
    }
}
