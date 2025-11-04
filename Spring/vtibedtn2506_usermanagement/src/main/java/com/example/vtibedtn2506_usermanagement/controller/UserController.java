package com.example.vtibedtn2506_usermanagement.controller;

import com.example.vtibedtn2506_usermanagement.dto.request.CreateUserDTO;
import com.example.vtibedtn2506_usermanagement.dto.request.UpdateUserDTO;
import com.example.vtibedtn2506_usermanagement.entity.User;
import com.example.vtibedtn2506_usermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
//    @Autowired
    private final UserService userService;

    @PostMapping()
    public User createUser(@RequestBody CreateUserDTO request) {
        return userService.createUser(request);
    }

    @GetMapping()
    public List<User> getAll () {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public User updateInfoUser (@RequestBody UpdateUserDTO request, @PathVariable Integer id) {

        return userService.updateInfoUser(request, id);
    }

    @GetMapping("/find")
    public List<User> findByFirstName(@RequestParam String firstName) {
        return userService.findByFirstName(firstName);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }
}
