package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.User;

public interface UserService {
     void register(UserRegisterBindingModel registerBindingModel);

     boolean authenticate(UserLoginBindingModel loginBindingModel);

     void registerAdmin();

    void logout();

    boolean userNameFree(String username);

    User getByFirstName(String username);
}
