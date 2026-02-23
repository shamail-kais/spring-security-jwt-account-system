package spring_boot_user_account.userAccount_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_user_account.userAccount_springboot.entity.Activity;
import spring_boot_user_account.userAccount_springboot.entity.User;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByUser(User user);
}