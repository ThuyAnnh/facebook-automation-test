package vn.sunasterisk.facebookautomationtest.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {
    public void loginFacebook(String email, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.facebook.com/"); // load 1 link URL\

        WebElement emailElement = webDriver.findElement(By.id("email"));
        emailElement.sendKeys(email);
        WebElement passwordElement = webDriver.findElement(By.id("pass"));
        passwordElement.sendKeys(password);

        WebElement loginButton = webDriver.findElement(By.xpath("//*[@name='login']"));
        loginButton.click();
        Thread.sleep(10000);

        String a = "Facebook";
        String titleFb = webDriver.getTitle();
        if (a.equals(titleFb)){
            System.out.println("["+email+"] - ["+password+"]: Login thành công");
        } else {
            WebElement messageElement = webDriver.findElement(By.xpath("//*[@class='_9ay7']"));
            System.out.println("["+email+"] - ["+password+"]: "+ messageElement.getText());
        }
        webDriver.close();
        webDriver.quit();
    }
}
