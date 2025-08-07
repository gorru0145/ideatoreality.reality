package important.ideatoreality.reality.dto;

import java.time.LocalDateTime;

public class Commentdto {

    private  Long pcid;
    private String comment;
    private LocalDateTime updateDateTime;
    private Long id;

    public Commentdto(Long pcid,String comment, LocalDateTime updateDateTime,Long id) {
        this.pcid=pcid;
        this.comment = comment;
        this.updateDateTime = updateDateTime;
        this.id=id;
    }

    public Long getPcid() {
        return pcid;
    }

    public void setPcid(Long pcid) {
        this.pcid = pcid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
