

import DAO.UserDAO;
import model.Fields;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class UserDAOTests {
    private UserDAO userDAO;
    private User testUser;
    private Map<String, String> trueParams;
    private Map<String, String> fakeParams;

    @Before
    public void init() {
        trueParams = new HashMap<>();
        fakeParams = new HashMap<>();
        trueParams.put(Fields.ID, "0");
        userDAO = new UserDAO();
        testUser = userDAO.select(trueParams).stream().findFirst().get();
        trueParams.clear();
    }

    @After
    public void tearDown() {
        userDAO = null;
        trueParams = null;
        fakeParams = null;
        testUser = null;
    }

    @Test
    public void testUserInsert() {
        User user = new User(100,"users");
        assertFalse(userDAO.getAll().contains(user));
        userDAO.insert(user);
        assertTrue(userDAO.getAll().contains(user));
        userDAO.delete(user);
    }

    @Test
    public void testUserSelect() {
        trueParams.put(Fields.ID, "" + testUser.getId());
        fakeParams.put(Fields.ID, "2");
        userDAO.select(trueParams);
        userDAO.select(fakeParams);
        assertEquals(testUser, userDAO.select(trueParams).stream().findFirst().get());
        assertNotEquals(testUser, userDAO.select(fakeParams).stream().findFirst().get());
        trueParams.clear();
        fakeParams.clear();
        trueParams.put(Fields.USER_LOGIN, testUser.getLogin());
        fakeParams.put(Fields.USER_LOGIN, "TheKid");
        assertEquals(testUser, userDAO.select(trueParams).stream().findFirst().get());
        assertNotEquals(testUser, userDAO.select(fakeParams).stream().findFirst().get());

    }

    @Test
    public void testUserUpdate() {
        trueParams.put(Fields.ID, testUser.getId() + "");
        User secondUser = new User(0, testUser.getLogin()+"fake");
        userDAO.update(testUser.getId(), secondUser);
        assertEquals(userDAO.select(trueParams).stream().findFirst().get(),secondUser);
        secondUser.setLogin(testUser.getLogin());
        userDAO.update(testUser.getId(),secondUser);

    }

    @Test
    public void testUserDelete() {
        assertTrue(userDAO.getAll().contains(testUser));
        userDAO.delete(testUser);
        assertFalse(userDAO.getAll().contains(testUser));
        userDAO.insert(testUser);
    }
}
