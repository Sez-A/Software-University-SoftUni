package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.binding.UserLoginBindingModel;
import bg.softuni.mobilelele.model.binding.UserRegisterBindingModel;
import bg.softuni.mobilelele.model.entity.User;

public interface UserService {
     void register(UserRegisterBindingModel registerBindingModel);

     boolean authenticate(UserLoginBindingModel loginBindingModel);

     void registerAdmin();

    boolean userNameFree(String username);

    User getByUserName(String username);
}
