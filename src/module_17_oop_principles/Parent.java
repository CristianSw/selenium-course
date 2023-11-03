package module_17_oop_principles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Parent {

    @BeforeMethod
    public void beforeRun(){
        System.out.println("Run me first.");
    }
    public void doThisFromParent(){
        System.out.println("From parent");
    }

    @AfterMethod
    public void afterRun(){
        System.out.println("After Run.");
    }
}
