package Base;


import Utils.ReadPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
public class BaseTest {

    private BaseDriver baseDriver;
    public WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"propertiesPath"})
    public void beforeSuite(@Optional("src/main/resources/config/config.properties") String propertiesPath) throws IOException {

        ReadPropertiesUtil.readProperties(propertiesPath);
    }


    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        baseDriver = new BaseDriver();
        driver =  baseDriver.startBrowser();
        log.info("浏览器启动成功");
    }
    @AfterTest
    public void afterTest(){
        baseDriver.closeBrowser();
    }
}
