package com.mika.credit.web.admin.util;

import com.mika.credit.facade.admin.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPasswd(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();
        user.setPasswd(newPassword);
    }

    public String encryptPassword(String source) {
        String salt = randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(
                algorithmName,
                source,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
        return newPassword;
    }
    public String encryptPassword(String source, String salt) {
        String newPassword = new SimpleHash(
                algorithmName,
                source,
                ByteSource.Util.bytes(salt),
                hashIterations).toHex();
        return newPassword;
    }

    @Test
    public void test(){
        String newPassword = new SimpleHash(
                algorithmName,
                "a123456",
                ByteSource.Util.bytes("yst"),
                hashIterations).toHex();
        System.out.println(newPassword);
        newPassword = new SimpleHash(
                algorithmName,
                "gavin",
                ByteSource.Util.bytes(randomNumberGenerator.nextBytes().toHex()),
                hashIterations).toHex();
        System.out.println(newPassword);
    }
}
