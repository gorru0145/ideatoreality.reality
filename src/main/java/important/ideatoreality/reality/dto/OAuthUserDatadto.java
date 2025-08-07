package important.ideatoreality.reality.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class OAuthUserDatadto {


    private Long aid;


    private String email;

    private String name;


    private String principaldetail;

    public OAuthUserDatadto(String email, String name, String principaldetail) {
        this.email = email;
        this.name = name;
        this.principaldetail = principaldetail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipaldetail() {
        return principaldetail;
    }

    public void setPrincipaldetail(String principaldetail) {
        this.principaldetail = principaldetail;
    }
}
