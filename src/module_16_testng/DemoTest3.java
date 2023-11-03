package module_16_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTest3 {

    @Test(groups = {"smoke"})
    public void MobileTest1(){}
    @Test
    public void MobileTest2(){}
    @Test(groups = {"smoke"})
    public void MobileTest3(){}
    @Test()
    public void MobileTest4(){}
    @Test
    public void MobileTest5(){}
    @Test
    public void MobileTest6(){}
    @Test
    public void MobileTest7(){}
    @Test(groups = {"smoke"})
    public void MobileTest8(){}

    @Test(groups = {"smoke"})
    public void APITest1(){}
    @Test
    public void APITest2(){}

    @Parameters({"url"})
    @Test
    public void APITest3(String url){
        System.out.println(url);
    }
    @Test(timeOut = 4000)
    public void APITest4(){}
    @Test(groups = {"smoke"})
    public void APITest5(){}
    @Test(enabled = false)
    public void APITest6(){}
    @Test(dependsOnMethods = {"MobileTest8", "APITest4"})
    public void APITest7(){}
    @Test(groups = {"smoke"})
    public void APITest8(){}

    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String passwd){
        System.out.println(username);
        System.out.println(passwd);
    }

    @DataProvider
    public Object[][] getData(){
        // 1st username, passwd - good history
        // 2nd username, passwd - bad history
        // 3rd username, passwd - 0 history
        Object[][] data = new Object[3][2];
        data[0][0] = "username1";
        data[0][1] = "passwd1";

        data[1][0] = "username2";
        data[1][1] = "passwd2";

        data[2][0] = "username3";
        data[2][1] = "passwd3";
return data;
    }

}
