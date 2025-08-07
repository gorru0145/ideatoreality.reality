package important.ideatoreality.reality.dto;

public class Modedto {

    private Long mid;
    private String mode;
    private String modedescription;
    private Destinationdto destination ;

    public UserDetailsdto getUser() {
        return user;
    }
    public void setUser(UserDetailsdto user) {
        this.user = user;
    }
    private UserDetailsdto user;

    public Destinationdto getDestination() {
        return destination;
    }
    public void setDestination(Destinationdto destination) {
        this.destination = destination;
    }
    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
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
