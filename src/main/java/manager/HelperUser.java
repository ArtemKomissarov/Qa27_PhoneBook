package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
//        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//        //xpath//a[text()='LOGIN']
//        loginTab.click();

        click(By.cssSelector("a[href='/login']"));
        logger.info("open form by click on button with locator By.cssSelector(\"a[href='/login']\") ");
    }


    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.name("email"), email);
        logger.info("type in input with locator By.name(\"email\")");
//
//        WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.xpath("//input[last()]"), password);
        // type(By.xpath("//input[la]"), password);
        logger.info("type in input with locator By.xpath(\"//input[last()]\")");


    }

    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.xpath("//input[last()]"), user.getPassword());

    }

    public void submitLogin() {
        click(By.xpath("//button[text()='Login']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public boolean isNoContactsHereDisplayed() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        return  wait.until(ExpectedConditions.textToBePresentInElement(
                wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")),
                "No Contacts here!"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }
}