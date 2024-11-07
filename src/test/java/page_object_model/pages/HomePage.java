package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{
    @FindBy(xpath = "//a[@id='register-button' and @class='eHeader-button' and @data-toggle='modal' and @data-target='#register']")
    public WebElement Register;

    @FindBy(xpath = "//a[@id='login-button' and @class='eHeader-button' and @data-toggle='modal' and @data-target='#login']")
    public WebElement Login;

    @FindBy(xpath = "//div[@class='Search-button']//input[@id='searching-text']")
    public WebElement SearchBox;

    @FindBy(xpath = "//div[@class='Search-button']//button[@type='submit']")
    public WebElement SearchBoxButton;

    // Form fields for registration
    @FindBy(xpath = "//input[@name='st_first_name']")
    public WebElement FirstNameField;

    @FindBy(xpath = "//input[@name='st_last_name']")
    public WebElement LastNameField;

    @FindBy(xpath = "//input[@name='student_email']")
    public WebElement EmailField;

    @FindBy(xpath = "//input[@name='student_phone']")
    public WebElement PhoneField;

    @FindBy(xpath = "//select[@name='gender' and contains(@class, 'reg-field')]")
    public WebElement GenderField;

    @FindBy(xpath = "//input[@name='student_password']")
    public WebElement PasswordField;

    @FindBy(xpath = "//input[@name='retype_password']")
    public WebElement ConfirmPasswordField;

    // Submit button for registration form
    @FindBy(xpath = "//button[@id='register_submit']")
    public WebElement RegisterButton;

    // Form fields for login
    @FindBy(xpath = "//input[@name='email']")
    public WebElement LoginEmailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement LoginPasswordField;

    //Login Submit
    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'btn-primary') and text()='LOGIN' and not(@id='mobile-login-submit')]")
    public WebElement LoginButton;

    //Become a Teacher
    @FindBy(xpath = "//div[@class='weblnars-button']/a[@id='weblnars-button' and contains(text(), 'Become a Teacher')]")
    public WebElement BecomeATeacherButton;

    //Course Button
    @FindBy(xpath = "//li[@class='eMenu-listItem']/a[@href='https://elearning.lk/courses']")
    public WebElement CoursesButton;


    String searchString = "";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void typeToSearchBox(String searchText) {
        //this.searchString = searchText;
        SearchBox.sendKeys((searchText));
    }

    public <T> void clickSearchBtn() {
        SearchBoxButton.click();
    }

    public void RegisterClick() {
        Register.click();
    }

    // Method to fill out the registration form
    public void fillRegistrationForm(String firstName, String lastName, String email, String phone, String gender, String password) {
        FirstNameField.sendKeys(firstName);
        LastNameField.sendKeys(lastName);
        EmailField.sendKeys(email);
        PhoneField.sendKeys(phone);
        PasswordField.sendKeys(password);
        ConfirmPasswordField.sendKeys(password);
        selectGender(gender);
    }

    public void selectGender(String gender) {
        new Select(GenderField).selectByVisibleText(gender);
    }

    public void submitRegistrationForm() {
        RegisterButton.click();
    }

    public void LoginClick() {
        Login.click();
    }

    public void fillLoginForm(String email, String password) {
        LoginEmailField.sendKeys(email);
        LoginPasswordField.sendKeys(password);
    }

    public void submitLogin() {
        LoginButton.click();
    }

    public <T> T clickBecomeTeacher() {
        BecomeATeacherButton.click();
        return (T) PageFactory.initElements(driver, TeacherPage.class);
    }

    public <T> T clickCourses() {
        CoursesButton.click();
        return (T) PageFactory.initElements(driver, CoursePage.class);
    }
}
