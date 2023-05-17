import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyJUnitTest {

    private static final String LOGIN_PAGE = "https://www.facebook.com/";
    private static WebDriver driver;

    private static String name;

    @BeforeAll
    public static void classSetup()throws InterruptedException{
        driver = MyDriver.getWebDriver();
        driver.get(LOGIN_PAGE);
        driver.manage().window().fullscreen();
        Thread.sleep(10000);
    }

    @AfterAll
    public static void classTearDown(){
        MyDriver.closeDriver();
    }
    @AfterEach
    public void testTearDown(){
        driver.get(LOGIN_PAGE);
    }
    @Test
    public void openLoginPageTest() {
        String actualURL = driver.getCurrentUrl();
        assertEquals(LOGIN_PAGE,actualURL,"URLs are not match!");
    }

    @Test
    public void beforeFullTest()throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")); //
        element.click();
        Thread.sleep(1000);
        assertNotNull(element);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Liana", "Diana", "Riana"})
    public void firstFullTest(String name) throws InterruptedException {

//        WebElement element = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")); //
//        element.click();
//        Thread.sleep(1000);
//        assertNotNull(element);

        WebElement elementFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement elementLastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        Thread.sleep(1000);

//        assertNotNull(elementFirstName);
//        assertNotNull(elementLastName);

        elementFirstName.sendKeys(name);
        elementLastName.sendKeys("Votchal");

        WebElement elementEmail = driver.findElement(By.xpath("//*[@name='reg_email__']"));
        WebElement elementPassword = driver.findElement(By.xpath("//*[@id='password_step_input']"));
        Thread.sleep(1000);

//        assertNotNull(elementFirstName);
//        assertNotNull(elementLastName);

        elementEmail.sendKeys("somebody@gmail.com");
        elementPassword.sendKeys("12345");

        WebElement selectYearElement = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        WebElement selectBirthYearElement = driver.findElement(By.xpath("//option[text()='1982']"));
        Thread.sleep(1000);

//        assertNotNull(selectYearElement);
//        assertNotNull(selectBirthYearElement);

        selectYearElement.click();
        selectBirthYearElement.click();

        WebElement elementGender = driver.findElement(By.xpath("//label[text()='Custom']"));
 //       WebElement elementGender = driver.findElement(By.xpath("//input[@id='u_3_6_dO']"));
        WebElement elementPronoun = driver.findElement(By.xpath("//option[text()='They: \"Wish them a happy birthday!\"']"));
        WebElement elementOptional = driver.findElement(By.xpath("//input[@name='custom_gender']"));

//        assertNotNull(elementGender);
//        assertNotNull(elementPronoun);
//        assertNotNull(elementOptional);

        elementGender.click();
        elementPronoun.click();
        elementOptional.sendKeys("covfefe");

        WebElement elementEmailConfirm = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        WebElement elementClickSignUp = driver.findElement(By.xpath("//button[@name='websubmit']"));

//        assertNotNull(elementEmailConfirm);
//        assertNotNull(elementClickSignUp);

        elementEmailConfirm.sendKeys("somebody@gmail.com");
        elementClickSignUp.click();

        Thread.sleep(10000); // has to stay

        WebElement errorElement = driver.findElement(By.xpath("//div[text()='Your password must be at least 6 characters long. Please try another.']"));

        if ((errorElement !=null)){
            elementPassword.sendKeys("123456");
            elementClickSignUp.click();
            Thread.sleep(1000);
        }
        else
            elementClickSignUp.click();

    }

//        String value = element2.getAttribute("value");
//        assertEquals("covfefe",value,"not equal");


}
