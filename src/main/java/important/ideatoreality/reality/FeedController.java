package important.ideatoreality.reality;

import important.ideatoreality.reality.model.UserFeed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FeedController {
    @RequestMapping("/")
    public String getUserFeed(UserFeed userdata){

        
        return  null;
    }
}
