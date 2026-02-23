package spring_boot_user_account.userAccount_springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import spring_boot_user_account.userAccount_springboot.entity.Activity;
import spring_boot_user_account.userAccount_springboot.entity.Hobby;
import spring_boot_user_account.userAccount_springboot.entity.User;
import spring_boot_user_account.userAccount_springboot.repository.ActivityRepository;
import spring_boot_user_account.userAccount_springboot.repository.HobbyRepository;
import spring_boot_user_account.userAccount_springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final HobbyRepository hobbyRepository;
    private final ActivityRepository activityRepository;

    @GetMapping("/userdetails")
    public ResponseEntity<?> getUserDetails(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return ResponseEntity.ok(user);
    }

    @GetMapping("/hobby")
    public ResponseEntity<?> getHobbies(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return ResponseEntity.ok(
                hobbyRepository.findByUser(user)
        );
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        return ResponseEntity.ok(
                activityRepository.findByUser(user)
        );
    }

    @PostMapping("/hobby")
    public ResponseEntity<?> addHobby(@RequestBody Hobby hobby,
                                      Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        hobby.setUser(user);

        hobbyRepository.save(hobby);

        return ResponseEntity.ok("Hobby Added");
    }

    @PostMapping("/activity")
    public ResponseEntity<?> addActivity(@RequestBody Activity activity,
                                      Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow();

        activity.setUser(user);

        activityRepository.save(activity);

        return ResponseEntity.ok("activity Added");
    }
}