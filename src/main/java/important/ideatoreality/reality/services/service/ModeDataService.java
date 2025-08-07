package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.Modedto;

import java.util.Optional;

public interface ModeDataService {

    public Modedto createUser(Modedto mode);

    public Optional<Modedto> getUserMode(Long id);

    public Modedto updateUserMode(Modedto mode);
    public Optional<Modedto> getModeByUserId(Long UserId);
}
