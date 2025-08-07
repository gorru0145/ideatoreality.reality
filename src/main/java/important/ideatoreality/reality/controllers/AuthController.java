package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.Exception.CustomAuthException;
import important.ideatoreality.reality.dto.UserDetailsdto;
import important.ideatoreality.reality.services.service.UserDetailsService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/auth/callback")
    public void redirectToFrontend(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:4200/auth-handler"); // Your Angular route
    }

    @GetMapping("/api/auth/check")
    public ResponseEntity<Map<String, Boolean>> checkSession() throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken);
        return ResponseEntity.ok(Map.of("authenticated", isAuthenticated));
    }

    @GetMapping("/api/user/is-registered")
    public ResponseEntity<Map<String, Boolean>> isRegistered(Authentication authentication) throws IOException {
        boolean isRegistered=false;
        String email = authentication.getName();
        UserDetailsdto userispresent = userDetailsService.getUserDetailsByEmail(email);
        if(userispresent!=null){
            isRegistered=true;
        }
        return ResponseEntity.ok(Map.of("registered", isRegistered));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        try {
            ResponseCookie deleteCookie = ResponseCookie.from("jwt", "")
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .sameSite("Lax")
                    .maxAge(0)
                    .build();

            response.addHeader(HttpHeaders.SET_COOKIE, deleteCookie.toString());
            return ResponseEntity.ok(true);
        } catch (Exception ex) {
            throw new CustomAuthException("Logout failed: " + ex.getMessage());
        }
    }


}
