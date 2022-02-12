package bg.softuni.mobilelele.model.binding;

public class UserLoginBindingModel {
    private String username;
    private String password;

    public UserLoginBindingModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
