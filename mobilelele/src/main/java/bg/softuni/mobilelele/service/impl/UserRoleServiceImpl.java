package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.model.entity.enums.Role;
import bg.softuni.mobilelele.model.entity.UserRole;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void populateDb() {
        if (this.userRoleRepository.count() == 0) {
            UserRole admin = new UserRole();
            admin.setRole(Role.ADMIN);
            UserRole user = new UserRole();
            user.setRole(Role.USER);
            this.userRoleRepository.save(admin);
            this.userRoleRepository.save(user);
        }
    }

    @Override
    public UserRole getAdminRole() {
        return this.userRoleRepository.findByRole(Role.ADMIN);
    }

    @Override
    public UserRole getUserRole() {
        return this.userRoleRepository.findByRole(Role.USER);
    }
}
