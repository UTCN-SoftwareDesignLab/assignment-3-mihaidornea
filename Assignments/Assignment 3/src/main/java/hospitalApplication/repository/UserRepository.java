package hospitalApplication.repository;

import hospitalApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {


    @Transactional
    void deleteByUsername(String username);

    User findByUsername(String username);
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.username = :newUsername WHERE u.email = :email")
    void updateUsername(@Param("newUsername") String newUsername, @Param("email") String email);

}
