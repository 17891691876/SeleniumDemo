package Page;

import Base.BasePageAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageAction {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    //页面相关数据
    public static final String url ="https://ad.hupu.com/#/";


    //  元素定位方式
    public static final By Username = By.id("account");
    public static final By Password = By.id("password");
    public static final By loginbutton = By.xpath("//*[@type='submit']");
    //public static final By failtoast = By.cssSelector("span[text='用户名或密码错误']");

    //页面相关操作
    //登陆操作
    public void doLogin(String username,String password ){
        enterPage(url);
        sendKeysInput(Username,username);
        sendKeysInput(Password,password);
        clickButton(loginbutton);
    }

    //登陆成功
    public HomePage login(String username,String password){
        doLogin(username,password);
        return new HomePage(driver);
    }

    //登陆失败
    public LoginPage loginFail(String username,String password){
        doLogin(username,password);
        return this;
    }

}
