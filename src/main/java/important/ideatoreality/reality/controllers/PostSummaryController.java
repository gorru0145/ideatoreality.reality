package important.ideatoreality.reality.controllers;

import important.ideatoreality.reality.dto.UserPostSummarydto;
import important.ideatoreality.reality.services.service.PostSummaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postdata")
public class PostSummaryController {
    @Autowired
    private PostSummaryDataService summaryService;

    @GetMapping("/{userid}")
    public List<UserPostSummarydto> getPostSummary(@PathVariable Long userid)throws Exception {
        return summaryService.getAllSummaries(userid);
    }



}
