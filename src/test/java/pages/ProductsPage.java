package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    protected WebDriver driver;

    private static final String ADD_TO_CARD_LOCATOR = "//button[@id='add-to-chart-sauce-labs-%s']";

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartCounter;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void addItemToTheCart(String productName) {

        String xpathOfTheElementToBeAdded = String.format(ADD_TO_CARD_LOCATOR, productName);
        WebElement addToCartButton = driver.findElement(By.xpath(xpathOfTheElementToBeAdded));
        addToCartButton.click();

    }

    public int getitmesInTheCart () {

return Integer.parseInt(shoppingCartCounter.getText());
    }



}

