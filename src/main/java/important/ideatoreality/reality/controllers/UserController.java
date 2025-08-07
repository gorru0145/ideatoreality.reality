package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.services.service.UserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/emailkey")
    public ResponseEntity<Map<String, String>> getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String email = (String) authentication.getPrincipal();
        Map<String, String> response = new HashMap<>();
        response.put("email", email);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/create")
    public UserDetailsdto createUser(@RequestBody UserDetailsdto userDetailsdto){
        UserDetailsdto user=userDetailsService.createUser(userDetailsdto);
        return user;
    }

    @GetMapping("/getuser/{id}")
    public Optional<UserDetailsdto> getUserDetailsById(@PathVariable Long id){
        Optional<UserDetailsdto> returnuser=userDetailsService.getUser(id);
        return returnuser;
    }

    @GetMapping("/getuserby/{email}")
    public UserDetailsdto getIdByEmail(@PathVariable String email)throws Exception{
        UserDetailsdto userDetailsdto=userDetailsService.getUserDetailsByEmail(email);
       // return userDetailsService.getUserId(email);
       return userDetailsdto;

    }

    @PutMapping("/update")
    public UserDetailsdto updateUserDetails(@RequestBody  UserDetailsdto userDetailsdto)throws Exception{
        return userDetailsService.updateUser(userDetailsdto);

    }


}
