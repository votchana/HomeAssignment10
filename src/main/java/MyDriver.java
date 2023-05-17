import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class MyDriver {

    private static WebDriver webDriver;
    public static WebDriver getWebDriver(){
        if(webDriver==null) {
            WebDriverManager.chromedriver().setup();
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }
    public static void closeDriver(){
        if(webDriver!=null) {
            webDriver.close();
        }
    }
}
