package module_17_oop_principles;

import org.testng.annotations.Test;

public class Child extends Parent{


    @Test
    public void testRun(){
        int a = 4;
        Utils util = new Utils(a);
        a = util.increment();
        doThisFromParent();
        System.out.println(a);
        a = util.multiplyTwo();
        System.out.println(a);
        a = util.multiplyThree();
        System.out.println(a);
    }
}
