package important.ideatoreality.reality.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Destinationdto {

    private Long did;
    private String plan;
    private String modeAnswer;
    private String capabilities;
    private Long rating;
    private UserDetailsdto user;
    private Modedto mode;

    public Destinationdto(Modedto mode, Long did, String plan, String modeAnswer, String capabilities, Long rating, UserDetailsdto user) {
        this.mode = mode;
        this.did = did;
        this.plan = plan;
        this.modeAnswer = modeAnswer;
        this.capabilities = capabilities;
        this.rating = rating;
        this.user = user;
    }

    public UserDetailsdto getUser() {
        return user;
    }

    public void setUser(UserDetailsdto user) {
        this.user = user;
    }

    public Modedto getMode() {
        return mode;
    }

    public void setMode(Modedto mode) {
        this.mode = mode;
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
