package important.ideatoreality.reality.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class OAuth2LoginException extends RuntimeException {
    public OAuth2LoginException(String message) {
        super(message);
    }
}
