package spring_boot_user_account.userAccount_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_user_account.userAccount_springboot.entity.Hobby;
import spring_boot_user_account.userAccount_springboot.entity.User;

import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {

    List<Hobby> findByUser(User user);
}