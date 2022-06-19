package app.facade;

import app.controllers.Constants.Constants;
import app.modules.Admin;
import app.modules.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FacadeImplentation implements Facade {

    @Override
    public void edit(User user) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(User user) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean register(String username, String password, String firstName, String lastName, String email) {
        EntityManager entityManager = getEntityManager();
        try {
            Query query = entityManager.createNamedQuery("User.findByUserName");
            query.setParameter("userName", username);
            List<User> users = query.getResultList();
            Admin userPrivileges = (Admin) entityManager.createNamedQuery("Admin.findById").setParameter("id", 2).getSingleResult();
            if (users.isEmpty()) {
                User user = new User();
                user.setUserName(username);
                user.setUserPassword(password);
                user.setUserEmail(email);
                user.setUserfirstName(firstName);
                user.setUserLastName(lastName);
                user.setPrivilieges(userPrivileges);
                entityManager.getTransaction().begin();
                entityManager.persist(user);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }

    }

    @Override
    public List<User> findAll() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return null;
        }
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("User.findByUserNameAndPassword");
        query.setParameter("userName", username);
        query.setParameter("userPassword", password);
        try {
            User user = (User) query.getSingleResult();//username -> unique
            return user;
        } catch (NoResultException exception) {
            return null;
        } catch (NonUniqueResultException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("BibliotekaPU");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PU_NAME);
        EntityManager em = emf.createEntityManager();
        return entityMangerFactory.createEntityManager();
    }

    @Override
    public Object getincorrectLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
