package important.ideatoreality.reality.services.service;

import important.ideatoreality.reality.dto.UserDetailsdto;

import java.util.Optional;

public interface UserDetailsService {

    UserDetailsdto createUser(UserDetailsdto userDto);

    UserDetailsdto getUserDetailsByEmail(String email_address);

    Optional<UserDetailsdto> getUser(Long userId );

    UserDetailsdto updateUser(UserDetailsdto userDetailsdto);





}
