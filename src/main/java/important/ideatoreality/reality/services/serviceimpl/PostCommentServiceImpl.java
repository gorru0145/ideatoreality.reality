package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.PostCommentdto;
import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.mapper.PostCommentDataMapper;
import important.ideatoreality.reality.mapper.PostDataMapper;
import important.ideatoreality.reality.mapper.UserDetailsMapper;
import important.ideatoreality.reality.model.PostComment;
import important.ideatoreality.reality.repository.PostCommentRepository;
import important.ideatoreality.reality.services.service.PostCommentService;
import important.ideatoreality.reality.services.service.PostSummaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCommentServiceImpl implements PostCommentService {

    @Autowired
    PostCommentRepository postCommentRepository;
    @Autowired
    PostCommentDataMapper postCommentDataMapper;
    @Autowired
    PostDataMapper postDataMapper;
    @Autowired
    UserDetailsMapper userDetailsMapper;
    @Autowired
    PostSummaryDataService postSummaryDataService;
    @Override
    public List<UserPostSummarydto> createcomment(PostCommentdto postCommentdto) {
        PostComment postComment=postCommentDataMapper.toEntity(postCommentdto);
        postComment.setPost(postDataMapper.toEntity(postCommentdto.getPost()));
        postComment.setUser(userDetailsMapper.toEntity(postCommentdto.getUser()));
        postCommentRepository.save(postComment);
        return postSummaryDataService.getAllSummaries();
    }

    @Override
    public List<UserPostSummarydto> updatecomment(PostCommentdto postCommentdto) {
        Optional<PostComment> foundresult=postCommentRepository.findById(postCommentdto.getPcid());
        if(foundresult.isPresent()){
            foundresult.get().setComment(postCommentdto.getComment());
            foundresult.get().setUpdateDateTime(postCommentdto.getUpdateDateTime());
            postCommentRepository.save(foundresult.get());
        }
        return postSummaryDataService.getAllSummaries();
    }

    @Override
    public List<UserPostSummarydto> deletecomment(Long pcid) {
        Optional<PostComment> foundresult=postCommentRepository.findById(pcid);

        if(foundresult.isPresent()){
            postCommentRepository.delete(foundresult.get());
        }
        return postSummaryDataService.getAllSummaries();
    }


}
