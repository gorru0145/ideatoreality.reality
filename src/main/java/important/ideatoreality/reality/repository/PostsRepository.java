package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.model.User_Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<User_Post,Long> {
    @Query("SELECT p FROM User_Post p LEFT JOIN FETCH p.comments")
    List<User_Post> findAllWithComments();

    List<User_Post> findByUser_Id(Long userId); // correct method
}
