package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.User;
import bg.softuni.mobilelele.user.CurrentUser;

public interface UserService {
     void register(UserRegisterBindingModel registerBindingModel);

     boolean authenticate(UserLoginBindingModel loginBindingModel);

     void registerAdmin();

    void logout();

    boolean userNameFree(String username);

    User getByUserName(String username);

    CurrentUser getCurrentUser();
}
