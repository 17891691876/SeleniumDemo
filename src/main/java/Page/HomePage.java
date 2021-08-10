package Page;

import Base.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class HomePage extends BasePageAction {
    public HomePage(WebDriver driver){
        super(driver);
    }

    public static final By pinpai = By.xpath("//*[@id='va-cc-fed']/div/div/div/div[2]/ul/li[2]");

    public WebElement getPinpai(By locol){
        locol = pinpai;
        WebElement pinpai = findElement(locol);
        return pinpai;
    }
}
