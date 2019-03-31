package cn.tedu.ttms.common.encryption;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @Author: lulin
 * @Date: 3/27/2019 11:28 PM
 * @Version 1.0
 */
public class SaltMd5TaskTest {

    @Test
    public void TestMd5() throws Exception {

        String saltStr = UUID.randomUUID().toString();
        saltStr="9052e391-2efa-4643-9332-585a4e657473";
        SaltMd5Task saltMd5Task =new SaltMd5Task(saltStr,"123456");
        saltMd5Task.run();
        Thread t1 = new Thread(saltMd5Task);
        t1.start();
        Thread threads[]=new Thread[10];
        for (Thread thread : threads) {
            Thread t=new Thread(saltMd5Task);
            t.start();
            System.out.println(saltMd5Task.toString());
        }


       /* for(int i=0;i<threads.length;i++){
            threads[i]=new Thread(saltMd5Task);
            threads[i].start();
        }*/
    }

}