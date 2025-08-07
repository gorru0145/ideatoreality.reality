package important.ideatoreality.reality.services.serviceimpl;

import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.mapper.UserDetailsMapper;
import important.ideatoreality.reality.model.UserDetails;
import important.ideatoreality.reality.repository.UserDetailsRepository;
import important.ideatoreality.reality.services.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    UserDetailsMapper userDetailsMapper;
    @Override
    public UserDetailsdto createUser(UserDetailsdto userDto) {
        try{
            UserDetails user=userDetailsMapper.toEntity(userDto);
            UserDetails saveduser=userDetailsRepository.save(user);
            UserDetailsdto outputuser=userDetailsMapper.toDto(saveduser);
            return outputuser;
        }
        catch (Exception e){
            System.err.println("Error saving user: " + e.getMessage());
            return null;
        }
    }

    @Override
    public UserDetailsdto getUserDetailsByEmail(String email_address) {
        Optional<UserDetails> userDetails=userDetailsRepository.findByEmailaddress(email_address);
        if(userDetails.isPresent()){
            UserDetails responseUser=userDetails.get();
            return userDetailsMapper.toDto(responseUser);
        }
        else {
            return null;
        }
    }

    // @Override
    //public Optional<Long> getUserId(String email_address) {
       // Optional<Long> userid=userDetailsRepository.findByEmail(email_address);
      //  return userid;
   // }

    @Override
    public Optional<UserDetailsdto> getUser(Long Userid) {
        Optional<UserDetails> userDetails=userDetailsRepository.findById(Userid);
        Optional<UserDetailsdto> userDetailsdto=userDetailsMapper.toOptionalDto(userDetails);
        return userDetailsdto;
    }

    @Override
    public UserDetailsdto updateUser( UserDetailsdto userDetailsdto) {
        Optional<UserDetails> userDetails=userDetailsRepository.findById(userDetailsdto.getId());
        if(userDetails.isPresent()){
            UserDetails unwrapuserDetails=userDetails.get();
            //unwrapuserDetails.setEmailaddress(userDetailsdto.getEmailaddress());
            unwrapuserDetails.setBio(userDetailsdto.getBio());
            unwrapuserDetails.setUsername(userDetailsdto.getUsername());
            //unwrapuserDetails.setMovie(userDetailsdto.getMovie());
            UserDetails updateduser=userDetailsRepository.save(unwrapuserDetails);
            UserDetailsdto opudresult=userDetailsMapper.toDto(updateduser);
            return opudresult;
        }
        else{
            return null;
        }
    }
}
