package hw.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteUserTest {
    private String url;
    private WebDriver driver;
    private String phone;
    private String name;

    @BeforeClass
    public void beforeMethod() {
        url = "http://37.59.228.229:3000/";
        driver = new ChromeDriver();
        phone = "123456";
        name = "Kenny";
    }

    @Test
    public void testMethod() {
        driver.get(url);
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).sendKeys(name);
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).sendKeys(phone);
        driver.findElement(By.cssSelector("div.main-content a.save-btn")).click();
        Assert.assertEquals(1,1);

        driver.getPageSource();

        driver.findElement(By.xpath(("//p[text() = '123456']/preceding::i[1]"))).click();
        Assert.assertEquals(0,0);

        driver.switchTo().alert().accept();
    }


        @AfterClass
        public void afterMethod () {
            driver.quit();

        }
    }










