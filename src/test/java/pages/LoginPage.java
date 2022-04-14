package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    // To set the driver
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(css = "[placeholder = Password]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginBtn;

    //To initialize the elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String username, String password) {
        userNameInput.click();
        userNameInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginBtn.click();

        return new ProductsPage (driver);



    }
    public void tryToLogin(String username, String password){
        userNameInput.click();
        userNameInput.sendKeys(username);

        passwordInput.click();
        passwordInput.sendKeys(password);

        loginBtn.click();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        WebElement errorLogin = driver.findElement(By.xpath("//*[text()='Epic sadface: "+errorMessage+"']"));
        return errorLogin.isDisplayed();
    }

}
