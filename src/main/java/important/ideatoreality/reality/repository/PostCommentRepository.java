package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment,Long> {

}
