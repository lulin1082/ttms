package cn.tedu.ttms.common.encryption;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * @Author: lulin
 * @Date: 3/8/2019 12:10 AM
 * @Version 1.0
 */

public class SaltMd5Task implements Runnable {

    private String password;
    private String salt;
    private String result;
    private final Object lockObj = new Object();

    @Override
    public String toString() {
        return "SaltMd5Task{" +
                "password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public SaltMd5Task(String salt, String password) {
        this.salt = salt;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void run() {
        ByteSource salt = ByteSource.Util.bytes(this.getSalt());
        Md5Hash md5Hash = new Md5Hash(this.getPassword(), "salt");
        this.result= md5Hash.toString();
    }
}


