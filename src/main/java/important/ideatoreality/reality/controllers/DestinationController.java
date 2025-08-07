package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.Destinationdto;
import important.ideatoreality.reality.services.service.DestinationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
public class DestinationController {
    @Autowired
    DestinationDataService destinationDataService;

    @PostMapping()
    public Destinationdto createdestinationuser(@RequestBody Destinationdto destinationdto) throws Exception{
        return destinationDataService.createUserDestination(destinationdto);
    }

    @PutMapping()
    public Destinationdto updatedestinationuser(@RequestBody Destinationdto destinationdto) throws Exception{
        return destinationDataService.updateUserDestination(destinationdto);
    }
}
