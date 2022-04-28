package imt.project.backend.Repository;

import imt.project.backend.Entity.HistoryInfo;
import imt.project.backend.Entity.IaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryInfo, Long> {

    List<HistoryInfo> getHistoryInfoByIa1OrIa2(IaInfo ia1, IaInfo ia2);
}
