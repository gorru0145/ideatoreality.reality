package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.dto.Commentdto;
import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.model.User_Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostRepository extends JpaRepository<User_Post,Long> {

    @Query("SELECT new important.ideatoreality.reality.dto.UserPostSummarydto( " +
            "u.id, u.username, m.mode, p.pid, p.addDateTime, " +
            "p.postWrittenData, p.postTags, p.imageLocation, COUNT(l)) " +
            "FROM UserDetails u " +
            "JOIN u.posts p " +
            "LEFT JOIN Mode m ON m.user = u " +
            "LEFT JOIN p.likes l " +
            "GROUP BY u.id, u.username, m.mode, p.pid, p.addDateTime, " +
            "p.postWrittenData, p.postTags, p.imageLocation " +
            "ORDER BY p.addDateTime DESC")
    List<UserPostSummarydto> fetchUserPostSummary();

    @Query("SELECT new important.ideatoreality.reality.dto.Commentdto(c.pcid,c.comment, c.updateDateTime,c.user.id) " +
            "FROM PostComment c WHERE c.post.pid = :postId")
    List<Commentdto> fetchCommentsByPostId(@Param("postId") Long postId);



}
