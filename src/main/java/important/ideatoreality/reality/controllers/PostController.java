package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.dto.UserPostdto;
import important.ideatoreality.reality.services.service.PostsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostsDataService postsDataService;

    @PostMapping()
    public List<UserPostSummarydto> createpost(@RequestBody UserPostdto userPostdto){
        return postsDataService.createpost(userPostdto);
    }

    @GetMapping("/getposts")
    public ResponseEntity<List<UserPostdto>> getallposts()throws Exception{
        List<UserPostdto> allposts=  postsDataService.getallposts();
        return new ResponseEntity<List<UserPostdto>>(allposts,HttpStatus.OK);
    }
    @GetMapping("/getuserposts/{userid}")
    public ResponseEntity<List<UserPostdto>> getalluserposts(@PathVariable Long userid)throws Exception{
        List<UserPostdto> alluserposts= postsDataService.getuserposts(userid);
        return new ResponseEntity<List<UserPostdto>>(alluserposts,HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<String> deletepost(@PathVariable Long postId,@PathVariable Long userId)throws Exception{
        String resp=postsDataService.deletepost(postId,userId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<UserPostdto> findPostByIdHandler(@PathVariable Long postId)throws Exception{
        UserPostdto postdto=postsDataService.findPostById(postId);
        return new ResponseEntity<>(postdto,HttpStatus.ACCEPTED);
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<Void> likepost(@PathVariable Long postId)throws  Exception{
        return ResponseEntity.ok().build();
    }

    @PutMapping("/posts/{postId}/user/{userId}")
    public ResponseEntity<UserPostdto> savedPostHandler(@PathVariable Long postId, @PathVariable Long userId)throws Exception{
        UserPostdto postdto=postsDataService.savedPost(postId,userId);
        return new ResponseEntity<>(postdto,HttpStatus.OK);
    }

    @PutMapping("/{postId}/like/user/{userId}")
    public List<UserPostSummarydto> likepost(@PathVariable Long postId,@PathVariable Long userId)throws Exception{
        return postsDataService.likePost(postId,userId);
        //return new ResponseEntity<UserPostdto>(userlikepost,HttpStatus.OK);
    }
}
