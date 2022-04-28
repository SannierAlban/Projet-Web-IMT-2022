package imt.project.backend.Repository;

import imt.project.backend.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findUserInfosByUserNameAndUserPassword(String userName, String userPassword);

}
