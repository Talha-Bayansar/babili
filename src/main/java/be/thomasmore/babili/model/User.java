package be.thomasmore.babili.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq",
            initialValue = 0, allocationSize = 1)
    @Id
    private int id;

    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    @ManyToOne
    private Cursus cursus;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<Inlevering> inleveringen;

    public User() {
    }

    public Cursus getCursus() {
        return cursus;
    }

    public void setCursus(Cursus cursus) {
        this.cursus = cursus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Inlevering> getInleveringen() {
        return inleveringen;
    }

    public void setInleveringen(Collection<Inlevering> inlevering) {
        this.inleveringen = inlevering;
    }
}
