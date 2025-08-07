package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.UserPostSummarydto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostSummaryDataService {

    public List<UserPostSummarydto> getAllSummaries() ;

}
