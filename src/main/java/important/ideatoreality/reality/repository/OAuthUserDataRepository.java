package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.model.OAuthUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OAuthUserDataRepository extends JpaRepository<OAuthUserData,Long> {


    Optional<OAuthUserData> findByEmail(String email);

}
