package imt.project.backend.Repository;

import imt.project.backend.Entity.IaInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IaRepository extends JpaRepository<IaInfo, Long> {

    List<IaInfo> findByName(String iaName);
}
