package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.model.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModeRepository extends JpaRepository<Mode,Long> {

    public Optional<Mode> findByUser_id(Long userId);


}
