package tests;

import manager.DataProviderUser;
import manager.TestNGListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LoginTests extends TestBase{




    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //is SignOut present---> logout
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method logout finish");
        }
    }

    //for jenkins
    @Test(dataProvider = "loginData",dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password){
        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email:" +email+" & password: "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email,password);
        app.getHelperUser().submitLogin();
        // Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element Button 'Sign out' present");
    }





    @Test(dataProvider = "loginModels",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user){
        logger.info("Test data ---> " +user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        // Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element Button 'Sign out' present");

    }

    @Test(dataProvider = "loginFile",dataProviderClass = DataProviderUser.class)
    public void loginSuccessModelDPF(User user){
        logger.info("Test data ---> " +user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        // Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element Button 'Sign out' present");

    }


    @Test(groups = {"smoke"})
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'maragmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("maragmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text 'Wrong email or password' present");

    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'mara@gmail.com' & password: 'Mmar123'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara@gmail.com","Mmar123");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text 'Wrong email or password' present");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'mara123@gmail.com' & password: 'Mmar123456$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mara123@gmail.com","Mmar123456$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert with error text 'Wrong email or password' present");

    }

}