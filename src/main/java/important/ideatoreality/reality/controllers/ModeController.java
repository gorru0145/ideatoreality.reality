package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.Modedto;
import important.ideatoreality.reality.services.service.ModeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/mode")
public class ModeController {

    @Autowired
    ModeDataService modeDataService;

    @PostMapping
    public Modedto createMode(@RequestBody Modedto modedto)throws Exception{
       return modeDataService.createUser(modedto);
    }

    @PutMapping
    public Modedto updateMode(@RequestBody Modedto updatemodedto)throws Exception{
        return modeDataService.updateUserMode(updatemodedto);
    }

    @GetMapping
    public Optional<Modedto> getMode(@RequestBody Long Id)throws Exception{
        return modeDataService.getUserMode(Id);
    }

    @GetMapping("user/{userId}")
    public Optional<Modedto> getModeByUserId(@PathVariable Long userId)throws Exception{
        return modeDataService.getModeByUserId(userId);
    }

}
