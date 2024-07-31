package entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void usersテーブルに対応している() {
        User user = new User();
        user.setUserId(10);
        user.setUserName("test");
        user.setTelNo("0120");

        assertEquals(Integer.valueOf(10), user.getUserId());
        assertEquals("test", user.getUserName());
        assertEquals("0120", user.getTelNo());
    }

    @Test
    public void 引数のあるコンストラクターがある() {
        User user = new User(10, "test", "0120");

        assertEquals(Integer.valueOf(10), user.getUserId());
        assertEquals("test", user.getUserName());
        assertEquals("0120", user.getTelNo());
    }

}