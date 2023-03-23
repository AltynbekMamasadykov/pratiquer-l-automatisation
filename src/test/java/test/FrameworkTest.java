package test;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.fastMail.FastMailLoginPage;
import pages.fastMail.FastMailMainPage;
import pages.protonMail.ProtonMailLoginPage;
import service.TestDataReader;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FrameworkTest extends CommonConditions{

    @Test
    public void FullFrameworkTest(){

        User testUserSender = UserCreator.withCredentialsFromProperty();
        User testUserReceiver = UserCreator.withReceiverCredentialsFromProperty();

                new ProtonMailLoginPage(driver)
                        .openPage()
                        .login(testUserSender)
                        .clickNewEmailButton()
                        .sendNewEmail(testUserReceiver);

                new FastMailLoginPage(driver)
                        .openPage()
                        .login(testUserReceiver)
                        .checkMail();

                FastMailMainPage fastMailMainPage = new FastMailMainPage(driver);

        Assert.assertTrue(fastMailMainPage.getSender().contains(testUserSender.getUsername()));

        assertThat(fastMailMainPage.getSubject(), is(equalTo(TestDataReader.getTestData("testdata.user.emailSubject"))));

        assertThat(fastMailMainPage.getEmailText(), is(equalTo(TestDataReader.getTestData("testdata.user.emailText"))));


    }

}
