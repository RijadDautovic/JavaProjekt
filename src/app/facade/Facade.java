package app.facade;

import app.modules.User;
import java.util.List;

;

public interface Facade {

    void edit(User user);

    void remove(User user);

    public boolean register(String username, String password, String firstName, String lastName, String email);

    List<User> findAll();

    public User login(String username, String password);

    public Object getincorrectLabel();

}
