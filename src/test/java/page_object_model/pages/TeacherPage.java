package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TeacherPage extends BasePage{

    public TeacherPage(WebDriver driver) {
        super(driver);
    }

    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x,y).perform();
    }
}
