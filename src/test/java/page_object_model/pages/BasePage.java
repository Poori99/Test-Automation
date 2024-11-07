package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage loadURL(String url) {
        driver.get(url);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
