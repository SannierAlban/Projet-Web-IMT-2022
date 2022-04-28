package imt.project.backend.Controller;

import imt.project.backend.Entity.HistoryInfo;
import imt.project.backend.Entity.IaInfo;
import imt.project.backend.Repository.HistoryRepository;
import imt.project.backend.Repository.IaRepository;
import imt.project.backend.Service.ServeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServeurController {

    @Autowired
    private ServeurService serveurService;
    @Autowired
    private IaRepository iaRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/server/confront")
    public HistoryInfo playConfront(@RequestParam("ia1")String ia1, @RequestParam("ia2") String ia2, @RequestParam(value = "round", defaultValue = "1") int round){

        IaInfo iaInfo1 = iaRepository.findByName(ia1).get(0);
        IaInfo iaInfo2 = iaRepository.findByName(ia1).get(0);

        return serveurService.playConfront(iaInfo1, iaInfo2, round);
    }

    @GetMapping("/server/getHistory")
    public List<HistoryInfo> getHistoryInfos(){
        return historyRepository.findAll();
    }

}
