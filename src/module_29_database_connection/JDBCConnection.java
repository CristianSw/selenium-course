package module_29_database_connection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String host = "localhost";
        String port = "3306";
        String username = "";
        String password = "";
        WebDriver driver = new ChromeDriver();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "cristian", "qazwsxgh32umym");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select username, password from credentials where scenario = 'nc_user'");
        while (resultSet.next()){
            username = resultSet.getString("username");
            password = resultSet.getString("password");
            System.out.println("username : " + username);
            System.out.println("password : " + password);
        }
        connection.close();

        driver.get("https://nc.sourcerunners.space/");
        driver.findElement(By.id("user")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }
}
