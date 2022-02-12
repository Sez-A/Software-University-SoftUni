package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.repository.UserRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import bg.softuni.mobilelele.service.UserService;
import bg.softuni.mobilelele.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final UserRoleService userRoleService;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, UserRoleService userRoleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.userRoleService = userRoleService;
        this.currentUser = currentUser;
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
    public void logout() {
        this.currentUser.clean();
    }

    @Override
    public boolean userNameFree(String username) {
        return this.userRepository.findByUsernameIgnoreCase(username).isEmpty();
    }

    @Override
    public User getByFirstName(String username) {
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

                currentUser.setLoggedIn(true)
                        .setFirstName(loggedIn.getFirstName())
                        .setLastName(loggedIn.getLastName())
                        .setUsername(loggedIn.getUsername());

                loggedIn.getRoles()
                        .forEach(r -> currentUser.addRole(r.getRole()));

                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
