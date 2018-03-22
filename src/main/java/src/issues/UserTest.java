package issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import issues.User;

public class UserTest {
    private User u1;
    private User u2;

    @Before
    public void setUp() throws Exception {
        u1 = new User();
        u2 = new User();
        u1.setId(45);
        u2.setId(45);
        u1.setLogin("vydehi");
        u2.setLogin("vydehi");
    }

    @Test
    public void testHashCode() {
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(u1.equals(u2));
    }

    @Test
    public void testToString() {
        String str1 = "User [login=vydehi, id=45]";
        assertEquals(str1, u1.toString());
        String str2 = "User [login=vydehi, id=45]";
        assertEquals(str2, u2.toString());
    }

}
