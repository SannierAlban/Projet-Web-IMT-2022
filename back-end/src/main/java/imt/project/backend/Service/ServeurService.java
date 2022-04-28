package imt.project.backend.Service;

import imt.project.backend.Entity.HistoryInfo;
import imt.project.backend.Entity.IaInfo;
import imt.project.backend.Repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class ServeurService {

    @Autowired
    HistoryRepository historyRepository;

    public ServeurService() {
    }

    public HistoryInfo playConfront(IaInfo ia1, IaInfo ia2, int round) {
        String line, resultat, score = "";
        try{
            Process process = Runtime.getRuntime().exec(
                    "python C:\\Users\\asannier\\Desktop\\ProjetWebImt\\hackagames\\game-risky\\confront.py "
                            .concat(ia1.getName()+".py" + " ").concat(ia2.getName()+".py")
            );
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));

            while((line = input.readLine()) != null){
                if(line.startsWith("score")){
                    score = line.substring(8, line.length() - 1);
                    //System.out.println(score);
                }
                System.out.println(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = score.split(", ");
        double finalResult = Double.parseDouble(result[0]) - Double.parseDouble(result[1]);

        HistoryInfo historyInfo = new HistoryInfo(ia1.getId(), ia2.getId(), finalResult, Timestamp.valueOf(LocalDateTime.now()));

        historyRepository.save(historyInfo);

        return historyInfo;
    }
}
