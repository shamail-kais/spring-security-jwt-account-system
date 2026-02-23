package spring_boot_user_account.userAccount_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_user_account.userAccount_springboot.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}