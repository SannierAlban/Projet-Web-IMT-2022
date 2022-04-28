package imt.project.backend.Repository;

import imt.project.backend.Entity.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User_info, Long> {
}
