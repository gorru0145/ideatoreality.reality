package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.Commentdto;
import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.repository.UserPostRepository;
import important.ideatoreality.reality.services.service.PostSummaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostSummaryDataServiceImpl implements PostSummaryDataService {

    @Autowired
    private UserPostRepository userPostRepository;


    @Override
    public List<UserPostSummarydto> getAllSummaries() {
        List<UserPostSummarydto> posts=userPostRepository.fetchUserPostSummary();
        for(UserPostSummarydto post : posts){
            List<Commentdto> comment =userPostRepository.fetchCommentsByPostId(post.getPostId());
            post.setComments(comment);
            if(post.getPostTags()!=null || post.getPostTags().trim().isEmpty()){
                post.setTagsArray(convertTags(post.getPostTags()));
            }
            else{
                post.setTagsArray(new String[0]);
            }
        }
        return posts;
    }

    public String[] convertTags(String tags) {
        return tags.contains(",")
                ? tags.split("\\s*,\\s*")  // trims around commas
                : new String[]{tags.trim()}; // single value
    }

}
