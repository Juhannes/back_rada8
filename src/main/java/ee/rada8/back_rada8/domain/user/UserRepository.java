package ee.rada8.back_rada8.domain.user;

import ee.rada8.back_rada8.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findUser(String username, String password);

}