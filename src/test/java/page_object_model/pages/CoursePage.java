package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CoursePage extends BasePage{

    @FindBy(xpath = "//input[@id='28']/following-sibling::span[@class='checkmark']")
    public WebElement SelectBox;

    @FindBy(xpath = "//select[@name='instructors']")
    public WebElement SelectDropdown;

    @FindBy(xpath = "(//div[@class='course-searchbar']//button[@class='filter' and @type='submit' and text()='Filter'])[1]")
    public WebElement FilterButton;

    String visibleText = " ";

    public CoursePage (WebDriver driver) {
        super(driver);
    }

    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x,y).perform();
    }

    public void selectCheckBox() {
        SelectBox.click();
    }

    public void selectItem(String visibleText) {
        this.visibleText = visibleText;
        new Select(SelectDropdown).selectByVisibleText(visibleText);
    }

    public void clickFilterButton() {
        FilterButton.click();
    }

}
