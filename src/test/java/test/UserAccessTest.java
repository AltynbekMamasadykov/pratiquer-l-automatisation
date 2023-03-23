package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.protonMail.ProtonMailLoginPage;
import service.UserCreator;


public class UserAccessTest extends CommonConditions{


    @Test(priority = 0)
    public void oneCanLoginProtoMail()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new ProtonMailLoginPage(driver)
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        Assert.assertTrue(loggedInUserName.contains(testUser.getUsername()));
    }

    @Test(priority = 1)
    public void inCorrectCredentialLogin()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean wrongCredentialsNotificationDisplayed = new ProtonMailLoginPage(driver)
                .openPage()
                .loginWithInCorrectCredentials(testUser);
        Assert.assertTrue(wrongCredentialsNotificationDisplayed);
    }

    @Test(priority = 2)
    public void emptyCredentialLogin()    {

        boolean fieldRequiredNotificationDisplayed = new ProtonMailLoginPage(driver)
                .openPage()
                .loginWithEmptyCredentials();
        Assert.assertTrue(fieldRequiredNotificationDisplayed);
    }

}
