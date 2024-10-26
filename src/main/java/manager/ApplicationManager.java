package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    HelperUser helperUser;
    HelperContact helperContact;

    WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        logger.info("All tests run in Chrome Browser");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverListener webDriverListener = new WDListener();
        wd = new EventFiringDecorator(webDriverListener).decorate(wd);


        wd.navigate().to("https://telranedu.web.app/");
        logger.info("The link--->" +wd.getCurrentUrl());
        helperUser = new HelperUser(wd);
        helperContact = new HelperContact(wd);
    }

    public HelperContact getHelperContact() {
        return helperContact;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop() {
        wd.quit();
    }
}