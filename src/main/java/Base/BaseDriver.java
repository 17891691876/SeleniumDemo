package Base;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class BaseDriver {
    public WebDriver driver;
    public WebDriver startBrowser(){
        try {
            //设置全局系统属性，jvm运行的时候会加载
            System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
            driver = new ChromeDriver();
            log.info("成功打开谷歌浏览器");
            return driver;
        }catch (Exception e){
            log.error("打开浏览器出错了"+e);
            return null;
        }
    }

    public void closeBrowser(){
        driver.quit();
    }

}
