package be.thomasmore.babili.model;

import jdk.jfr.Name;

import javax.persistence.*;

@Entity
@SuppressWarnings({"JpaDataSourceORMInspection"})
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"opdracht_id", "user_id"})
)
public class Inlevering {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inlevering_generator")
    @SequenceGenerator(name = "inlevering_generator", sequenceName = "inlevering_seq",
            initialValue = 0, allocationSize = 1)
    @Id
    private Integer id;
    private String audioPath;
    @ManyToOne
    private Opdracht opdracht;
    @ManyToOne
    private User user;
    private String beoordeling;
    private String feedback;

    public Inlevering() {
    }

    public Inlevering(String audioPath, Opdracht opdracht, User user){
        this.audioPath = audioPath;
        this.opdracht = opdracht;
        this.user = user;
    }

    public String getBeoordeling() {
        return beoordeling;
    }

    public void setBeoordeling(String beoordeling) {
        this.beoordeling = beoordeling;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(String audioPath) {
        this.audioPath = audioPath;
    }

    public Opdracht getOpdracht() {
        return opdracht;
    }

    public void setOpdracht(Opdracht opdracht) {
        this.opdracht = opdracht;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
