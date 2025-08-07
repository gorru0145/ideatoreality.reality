package important.ideatoreality.reality.model;

import jakarta.persistence.*;

@Entity
@Table(name="mode")
public class Mode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    private String mode;
    @Column(name="mode_description")
    private String modedescription;
    @ManyToOne
    @JoinColumn(name ="user_id")
    private UserDetails user;
    @OneToOne(mappedBy = "mode",cascade = CascadeType.ALL)
    private Destination destination;
    public void setMid(Long mid) {
        this.mid = mid;
    }
    public UserDetails getUser() {
        return user;
    }
    public void setUser(UserDetails user) {
        this.user = user;
    }
    public Destination getDestination() {
        return destination;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }
    public Long getMid() {
        return mid;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public String getModedescription() {
        return modedescription;
    }
    public void setModedescription(String modedescription) {
        this.modedescription = modedescription;
    }
}
