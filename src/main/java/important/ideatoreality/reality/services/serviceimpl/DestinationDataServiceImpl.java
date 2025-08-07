package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.Destinationdto;
import important.ideatoreality.reality.mapper.DestinationDataMapper;
import important.ideatoreality.reality.model.Destination;
import important.ideatoreality.reality.repository.DestinationRepository;
import important.ideatoreality.reality.services.service.DestinationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationDataServiceImpl implements DestinationDataService {
    @Autowired
    DestinationDataMapper destinationDataMapper;
    @Autowired
    DestinationRepository destinationRepository;

    @Override
    public Destinationdto createUserDestination(Destinationdto destinationdto) {
        Destination savedresult;
        Optional<Destination> destinationispresent =destinationRepository.findByMode_mid(destinationdto.getMode().getMid());
        if(destinationispresent.isPresent()){
            destinationispresent.get().setCapabilities(destinationdto.getCapabilities());
            destinationispresent.get().setModeAnswer(destinationdto.getModeAnswer());
            destinationispresent.get().setPlan(destinationdto.getPlan());
            destinationispresent.get().setRating(destinationdto.getRating());
            savedresult=destinationRepository.save(destinationispresent.get());
        }
        else {
            Destination destinationmodel=destinationDataMapper.toEntity(destinationdto);
            savedresult=destinationRepository.save(destinationmodel);
        }
        return destinationDataMapper.toDto(savedresult);
    }

    @Override
    public Destinationdto getUserDestination(Destinationdto destinationdto) {
        Destination destinationmodel=destinationDataMapper.toEntity(destinationdto);

        return null;
    }

    @Override
    public Destinationdto updateUserDestination(Destinationdto destinationdto) {
        Optional<Destination> findresult=destinationRepository.findById(destinationdto.getDid());

        if(findresult.isPresent()){
            Destination updateentity=destinationDataMapper.toEntity(destinationdto);
            Destination savedresult=destinationRepository.save(updateentity);
            return destinationDataMapper.toDto(savedresult);
        }
        else {
            return null;
        }
       // return null;
    }
}
