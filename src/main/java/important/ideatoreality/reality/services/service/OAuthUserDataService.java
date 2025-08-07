package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.OAuthUserDatadto;

import java.util.Optional;

public interface OAuthUserDataService {

    OAuthUserDatadto createoauthuser(OAuthUserDatadto authuser);

    Optional<OAuthUserDatadto> getoauthuserdetails(String email);
}
