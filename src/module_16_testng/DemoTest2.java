package module_16_testng;

import org.testng.annotations.*;

public class DemoTest2 {

    @BeforeSuite
    public void beforeSuiteStuff(){
        System.out.println("before all suite");
    }
    @AfterSuite
    public void afterSuiteStuff(){
        System.out.println("After suite stuff");
    }
    @AfterMethod
    public void afterMethodStuff(){
        System.out.println("After method stufffF");
    }
    @BeforeMethod
    public void beforeMethodStuff(){
        System.out.println("Before each test");
    }

    @BeforeTest
    public void prerequisite(){
        System.out.println("Init data or cleaning stuff");
    }

    @Test(groups = {"smoke"})
    public void test3(){
        System.out.println("!!!!!!!!!");
    }
    @Test
    public void test4(){
        System.out.println("test4");
    }
    @Test(groups = {"smoke"})
    public void test5(){
        System.out.println("test5");
    }

    @AfterTest
    public void beforeTest(){
        System.out.println("before exec tests do this :)");
    }
}
