package cc.flexapi;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.jupiter.api.Test;

/**
 * @author ckkk
 * @version 1.0
 * @description
 * @since 2026-04-25 11:40
 */
public class BCryptTest {

    @Test
    public void testBCrypt() {
        String password = "123456";
        String hash = BCrypt.hashpw(password);
        System.out.println(hash);
    }

    @Test
    public void testBCryptVerify() {
        String password = "";
        System.out.println(BCrypt.checkpw(password,""));
    }
}
