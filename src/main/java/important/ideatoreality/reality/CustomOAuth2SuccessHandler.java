package important.ideatoreality.reality;

import important.ideatoreality.reality.Exception.OAuth2LoginException;
import important.ideatoreality.reality.JWT.JwtUtil;
import important.ideatoreality.reality.controllers.AuthController;
import important.ideatoreality.reality.dto.OAuthUserDatadto;
import important.ideatoreality.reality.services.service.OAuthUserDataService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private OAuthUserDataService oAuthUserDataService;

    @Autowired
    private AuthController authController;



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        try {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

            String email = oauthToken.getPrincipal().getAttribute("email");
            String username = oauthToken.getPrincipal().getAttribute("given_name");

            if (email == null || username == null) {
                throw new IllegalStateException("OAuth2 login missing required attributes (email/username)");
            }

            OidcUser oidcUser = (OidcUser) oauthToken.getPrincipal();
            String idTokenValue = oidcUser.getIdToken().getTokenValue();

            String jwt = jwtUtil.generateToken(email, username);

            // Check if user exists, else create
            oAuthUserDataService.getoauthuserdetails(email)
                    .orElseGet(() -> {
                        return oAuthUserDataService.createoauthuser(
                                new OAuthUserDatadto(email, username, oauthToken.getPrincipal().toString()));
                    });

            // Create HttpOnly JWT cookie
            ResponseCookie cookie = ResponseCookie.from("jwt", jwt)
                    .httpOnly(true)
                    .secure(true) // Set to true in production
                    .path("/")
                    .sameSite("None")
                    .maxAge(3600)
                    .build();

            response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());


            authController.redirectToFrontend(response);

        } catch (Exception e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "OAuth2 Login Failed");
            } catch (Exception ex) {
                throw new OAuth2LoginException("OAuth2 login failed: " + ex.getMessage());
            }
        }
    }
}
