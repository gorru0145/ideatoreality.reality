package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.PostCommentdto;
import important.ideatoreality.reality.dto.UserPostSummarydto;

import java.util.List;

public interface PostCommentService {

    public List<UserPostSummarydto> createcomment(PostCommentdto postCommentdto);

    public List<UserPostSummarydto> updatecomment(PostCommentdto postCommentdto);

    public boolean deletecomment( Long pcid);

}
