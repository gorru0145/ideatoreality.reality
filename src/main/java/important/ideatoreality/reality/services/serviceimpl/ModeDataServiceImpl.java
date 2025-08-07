package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.Modedto;
import important.ideatoreality.reality.mapper.ModeDataMapper;
import important.ideatoreality.reality.model.Mode;
import important.ideatoreality.reality.repository.ModeRepository;
import important.ideatoreality.reality.services.service.ModeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModeDataServiceImpl implements ModeDataService {

    @Autowired
    ModeRepository modeRepository;

    @Autowired
    ModeDataMapper modeDataMapper;

    @Override
    public Modedto createUser(Modedto mode) {
        Mode resultMode;
        Optional<Mode> foundmode=modeRepository.findById(mode.getUser().getId());
        if(foundmode.isPresent()){
            foundmode.get().setMode(mode.getMode());
            foundmode.get().setModedescription(mode.getModedescription());
            resultMode=modeRepository.save(foundmode.get());
        }
        else{
            Mode Emode=modeDataMapper.toEntity(mode);
             resultMode=modeRepository.save(Emode);
        }

        return modeDataMapper.toDto(resultMode);
    }

    @Override
    public Optional<Modedto> getUserMode(Long id) {
        Optional<Mode> resultmodedata=modeRepository.findById(id);

        if(resultmodedata.isPresent()){
            return modeDataMapper.toOptionalDto(resultmodedata);

        }

        return null;

    }

    public Optional<Modedto> getModeByUserId(Long UserId){
        Optional<Mode> resultmodedata=modeRepository.findByUser_id(UserId);
        if(resultmodedata.isPresent()){
            return modeDataMapper.toOptionalDto(resultmodedata);
        }
        return null;
    }

    @Override
    public Modedto updateUserMode(Modedto mode) {
        return null;
    }


}
