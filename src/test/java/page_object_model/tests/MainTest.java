package page_object_model.tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_object_model.classes.User;
import page_object_model.pages.BasePage;
import page_object_model.pages.CoursePage;
import page_object_model.pages.HomePage;
import page_object_model.pages.TeacherPage;
import page_object_model.utilities.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class MainTest extends Utilities {

    @Test(priority = 1)
    public void test_one() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadURL("https://elearning.lk/");
        homePage.SearchBox.click();
        homePage.SearchBox.sendKeys("ICT");
        homePage.clickSearchBtn();
        sleep(6000);
    }

    @Test(priority = 2)
    public void test_two() throws InterruptedException, IOException {

        User user = readFromExcel("C:\\Users\\PoornimaJayathilake\\OneDrive - Xyicon\\Documents\\My\\4 year\\SQA\\Lec\\practicals\\sheet1.xlsx");

        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadURL("https://elearning.lk/");
        homePage.RegisterClick();
        homePage.fillRegistrationForm(
                user.getFirstName(), // First Name
                user.getLastName(),  // Last Name
                user.getEmail(),     // Email
                user.getPhoneNumber(), // Phone Number
                user.getGender(),    // Gender
                user.getPassword()   // Password
        );
        homePage.submitRegistrationForm();
        sleep(6000);
    }

    public User readFromExcel(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("sheet1");

        // Assuming data is in the second row (index 1)
        Row row = sheet.getRow(1);

        // Extract data based on the cell type
        String firstName = getCellValueAsString(row.getCell(0));
        String lastName = getCellValueAsString(row.getCell(1));
        String email = getCellValueAsString(row.getCell(2));
        String phoneNumber = getCellValueAsString(row.getCell(3));
        String gender = getCellValueAsString(row.getCell(4));
        String password = getCellValueAsString(row.getCell(5));

        // Create a new User object with data from the Excel sheet
        User user = new User(firstName, lastName, email, phoneNumber, gender, password);

        // Close the workbook and input stream
        workbook.close();
        fis.close();

        return user;
    }

    // Helper method to handle different cell types
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            default:
                return "";
        }
    }

    @Test(priority = 3)
    public void test_three() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadURL("https://elearning.lk/");
        homePage.LoginClick();
        homePage.fillLoginForm("poornimajayathilake1999@gmail.com", "123456");
        homePage.submitLogin();
        sleep(6000);
    }

    @Test(priority = 4)
    public void test_four() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadURL("https://elearning.lk/");
        TeacherPage teacherPage = homePage.clickBecomeTeacher();
        teacherPage.scrollPage(0, 900);
        sleep(6000);
    }

    @Test(priority = 5)
    public void test_five() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        HomePage homePage = basePage.loadURL("https://elearning.lk/");
        CoursePage coursePage = homePage.clickCourses();
        coursePage.scrollPage(0,100);
        coursePage.selectCheckBox();
        coursePage.selectItem("Sanjaya Elvitigala");
        coursePage.clickFilterButton();
        sleep(6000);
    }
}
