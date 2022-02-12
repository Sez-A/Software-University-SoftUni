package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.UserRole;

public interface UserRoleService {
    void populateDb();

    UserRole getAdminRole();

    UserRole getUserRole();
}
