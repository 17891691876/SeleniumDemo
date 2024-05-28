package Case;

import Base.BaseTest;
import Page.HomePage;
import Page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Slf4j
public class LoginCase extends BaseTest {
    public LoginPage loginPage;

    @Test(description = "登陆成功测试")
    @Parameters({"username","password"})
    public void testLogin(String username,String password){
        loginPage = new LoginPage(driver);
        HomePage Hpage = loginPage.login(username,password);
        Assert.assertEquals(Hpage.findElement(HomePage.pinpai).getText(),"品牌广告");
    }

    @Test //(expectedExceptions = Exception.class)
    @Parameters({"username","password"})
    public void testLoginFail(String username,String password){
        loginPage = new LoginPage(driver);
        loginPage = loginPage.loginFail(username,password);
        loginPage.findElement(loginPage.Password);
    }

    @Test(description = "测试图片对比")
    public void testCompare(){

    }

}
