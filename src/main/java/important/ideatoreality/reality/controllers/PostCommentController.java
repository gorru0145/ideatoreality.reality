package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.Commentdto;
import important.ideatoreality.reality.dto.PostCommentdto;
import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.repository.PostCommentRepository;
import important.ideatoreality.reality.services.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class PostCommentController {
    @Autowired
    PostCommentService postCommentService;
    @PostMapping()
    public List<UserPostSummarydto> addnewcomment(@RequestBody PostCommentdto newcomment)throws Exception{
        return postCommentService.createcomment(newcomment);
    }

    @PutMapping("/update")
    public List<UserPostSummarydto> updatecomment(@RequestBody PostCommentdto updatecomment)throws Exception{
         return postCommentService.updatecomment(updatecomment);
    }

    @DeleteMapping("/delete/{postcommentid}")
    public List<UserPostSummarydto> deletecomment(@PathVariable Long postcommentid)throws Exception{
        return postCommentService.deletecomment(postcommentid);
    }


    
}
