package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import bg.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
                           ModelMapper modelMapper, UserRoleService userRoleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
    }

    @Override
    public void registerAdmin() {
        if (this.userRepository.count() == 0) {
            User admin = new User();
            admin.setFirstName("Seza");
            admin.setLastName("Bey");
            admin.setUsername("Admin");
            admin.setCreated(Instant.now());
            Set<UserRole> roles = admin.getRoles();
            roles.add(this.userRoleService.getUserRole());
            roles.add(this.userRoleService.getAdminRole());
            admin.setRoles(roles);
            admin.setPassword(passwordEncoder.encode("test"));
            this.userRepository.save(admin);
        }
    }

    @Override
    public boolean userNameFree(String username) {
        return this.userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public User getByUserName(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void register(UserRegisterBindingModel registerBindingModel) {
        registerBindingModel.setUsername(registerBindingModel.getUsername().trim());
        registerBindingModel.setPassword(passwordEncoder.encode(registerBindingModel.getPassword()));
        User user = this.modelMapper.map(registerBindingModel, User.class);
        user.setCreated(Instant.now());
        Set<UserRole> roles = user.getRoles();
        roles.add(this.userRoleService.getUserRole());
        user.setRoles(roles);
        this.userRepository.save(user);

    }

    @Override
    public boolean authenticate(UserLoginBindingModel loginBindingModel) {
        String rawPassword = loginBindingModel.getPassword();
        User loggedIn = this.userRepository.findByUsername(loginBindingModel.getUsername());
        if (loggedIn != null) {
            boolean passIsValid = this.passwordEncoder.matches(rawPassword, loggedIn.getPassword());
            if (passIsValid) {
                // TODO Logic for login
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
