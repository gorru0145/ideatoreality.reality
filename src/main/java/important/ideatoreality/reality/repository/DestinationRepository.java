package important.ideatoreality.reality.repository;

import important.ideatoreality.reality.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination,Long> {

    public Optional<Destination> findByMode_mid(Long modeid);
}
