package module_16_testng;

import org.testng.annotations.Test;

public class DemoTest {

    @Test(groups = {"smoke"})
    public void test1(){
        System.out.println("hello");
    }

    @Test
    public void test2(){
        System.out.println("world");
    }
}
