package Base;

import Utils.ReadPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * 封装页面元素的基本操作
 */
@Slf4j
public class BasePageelement {
    //驱动
    protected WebDriver driver;
    //键盘等操作
    protected Actions actions;
    //js脚本定位操作
    protected JavascriptExecutor je;
    //显示等待
    protected WebDriverWait wait;

    protected WebElement wm;
    /**
     * 构造器 1
     *
     * @param driver 驱动
     */
    public BasePageelement(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.je = ((JavascriptExecutor) driver);
        // 显示等待时长
//        String a = ReadPropertiesUtil.getKey("driver.timeouts.webDriverWait");
//        log.info("qqqqqqqqq"+a);
        long timeout = Long.parseLong(ReadPropertiesUtil.getKey("driver.timeouts.webDriverWait"));

        this.wait = new WebDriverWait(driver, timeout);
    }

    //页面跳转
    public void enterPage(String url){
        driver.get(url);
    }

    //获取元素方法
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //点击操作
    public WebElement clickButton(By locator) {
        WebElement buttonElement = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        buttonElement.click();
        return buttonElement;
    }

    //输入框输入
    public WebElement sendKeysInput(By locator,CharSequence... content){
        WebElement input = findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        input.clear();
        input.sendKeys(content);
        return input;
    }

}
