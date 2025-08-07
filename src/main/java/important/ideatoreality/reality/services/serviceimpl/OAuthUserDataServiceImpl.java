package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.OAuthUserDatadto;
import important.ideatoreality.reality.mapper.OAuthUserDataMapper;
import important.ideatoreality.reality.model.OAuthUserData;
import important.ideatoreality.reality.repository.OAuthUserDataRepository;
import important.ideatoreality.reality.services.service.OAuthUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OAuthUserDataServiceImpl implements OAuthUserDataService {

    @Autowired
    OAuthUserDataRepository oAuthUserDataRepository;

    @Autowired
    OAuthUserDataMapper oAuthUserDataMapper;

    @Override
    public OAuthUserDatadto createoauthuser(OAuthUserDatadto authuser) {

        OAuthUserData oauthrequser=oAuthUserDataMapper.toEntity(authuser);
        OAuthUserData output= oAuthUserDataRepository.save(oauthrequser);

        return oAuthUserDataMapper.toDto(output);
    }

    @Override
    public Optional<OAuthUserDatadto> getoauthuserdetails(String email) {
        Optional<OAuthUserData> oauthdbdata=oAuthUserDataRepository.findByEmail(email);

        return oAuthUserDataMapper.toOptionalDto(oauthdbdata);
    }
}
