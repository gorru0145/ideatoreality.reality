package important.ideatoreality.reality.model;

import jakarta.persistence.*;

@Entity
@Table(name="destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    @Column(name="plan")
    private String plan;
    @Column(name="mode_answer")
    private String modeAnswer;
    @Column(name="capabilities")
    private String capabilities;
    @Column(name="rating")
    private Long rating;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDetails user;
    @OneToOne
    @JoinColumn(name ="mode_id")
    private Mode mode;

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getModeAnswer() {
        return modeAnswer;
    }

    public void setModeAnswer(String modeAnswer) {
        this.modeAnswer = modeAnswer;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
