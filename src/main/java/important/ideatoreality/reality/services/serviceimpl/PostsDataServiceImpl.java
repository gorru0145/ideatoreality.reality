package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.dto.UserPostdto;
import important.ideatoreality.reality.mapper.PostDataMapper;
import important.ideatoreality.reality.mapper.UserDetailsMapper;
import important.ideatoreality.reality.model.UserDetails;
import important.ideatoreality.reality.model.User_Post;
import important.ideatoreality.reality.repository.PostsRepository;
import important.ideatoreality.reality.repository.UserDetailsRepository;
import important.ideatoreality.reality.services.service.PostSummaryDataService;
import important.ideatoreality.reality.services.service.PostsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsDataServiceImpl  implements PostsDataService {
    @Autowired
    PostsRepository postsRepository;
    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    PostDataMapper postDataMapper;
    @Autowired
    PostSummaryDataService postSummaryDataService;
    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Override
    public boolean createpost(UserPostdto userPostdto) {
        User_Post userPost=postDataMapper.toEntity(userPostdto);
        userPost.setUser(userDetailsMapper.toEntity(userPostdto.getUser()));
        User_Post result=postsRepository.save(userPost);
        return result != null ? true : false;
    }

    @Override
    public List<UserPostdto> getallposts() {
        List<User_Post> result= postsRepository.findAll();
        return postDataMapper.toDtoList(result);
    }

    @Override
    public List<UserPostdto> getuserposts(Long userid) {
        List<User_Post> result= postsRepository.findByUser_Id(userid);
        return postDataMapper.toDtoList(result);
    }

    @Override
    public UserPostdto findPostById(Long postId) {
        Optional<User_Post> post=postsRepository.findById(postId);
        if(post.isPresent()) {
            return postDataMapper.toDto(post.get());
        }
        else {
            return null;
        }
    }

    @Override
    public List<UserPostSummarydto> likePost(Long postId, Long userId) {
        Optional<User_Post> post=postsRepository.findById(postId);
        Optional<UserDetails> user =userDetailsRepository.findById(userId);
        if(user.isPresent() && post.isPresent()){
            if(post.get().getLikes().contains(user.get())){
                post.get().getLikes().remove(user.get());
            }
            else {
                post.get().getLikes().add(user.get());
            }
            User_Post result=postsRepository.save(post.get());

            return postSummaryDataService.getAllSummaries(userId);
        }
        return null;
    }

    @Override
    public String deletepost(Long postid, Long userId) {
        return "";
    }

    @Override
    public UserPostdto savedPost(Long postId, Long userId) {
        //check the current state of post in userdetails table
        Optional<User_Post> post=postsRepository.findById(postId);

        Optional<UserDetails> user=userDetailsRepository.findById(userId);

        if(user.get().getPosts().contains(post)){
            user.get().getPosts().remove(post);
        }
        else {
            user.get().getPosts().add(post.get());

        }
        userDetailsRepository.save(user.get());

        return postDataMapper.toDto(post.get());
    }


}
