package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.dto.UserPostdto;

import java.util.List;

public interface PostsDataService {

    boolean createpost(UserPostdto userPostdto);
    List<UserPostdto> getallposts();
    List<UserPostdto> getuserposts(Long userid);
    UserPostdto findPostById(Long postId);
    List<UserPostSummarydto> likePost(Long postId , Long userId);
    String deletepost(Long postid,Long userId);
    UserPostdto savedPost(Long postId,Long userId);


}
