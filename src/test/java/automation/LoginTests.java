package automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.csvHelper;

import java.io.IOException;


public class LoginTests extends TestUtil {

    //Data needed for wrong test with wrong usernames or passwords - input in code.
    @DataProvider(name = "wrongUserList")
    public Object[][] getWrongUsers() throws IOException, CsvException {
        return new Object[][]{
                {"wrongUser", "wrongPassWord"},
                {"wrongUser", "secret_sauce"},
                {"standard_user", "wrongPassWord"}
        };
    }

    //Data needed for tests with correct usernames and passwords - input in csv file.
    @DataProvider(name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return csvHelper.readCsvFile("src/test/resources/users.csv");
    }

    @Test(dataProvider = "wrongUserList")
    public void UnsuccessfulLogin(String userName, String password) {

    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productPage = loginPage.login(userName, password);}

    @Test(dataProvider = "csvUserList")
    public void SuccessfulLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productPage = loginPage.login(userName, password);

    }


}

