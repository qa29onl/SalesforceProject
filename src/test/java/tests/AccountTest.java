package tests;

import objects.Account;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AccountTest extends BaseTest {
    Random random = new Random();

    @Test
    public void createAccountTest() {
        Account account = new Account();
        account.setAccountName("account" + random.nextInt(100));
        account.setWebsite("website");
        account.setType("Investor");
        account.setPhone("80170000000");
        account.setDescription("some text");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openNewAccountModalPage()
                .createNewAccount(account);
        accountListPage.openPage(ACCOUNT_LIST_URL);
        Assert.assertEquals(accountListPage.getExistAccountName(account.getAccountName()), account.getAccountName());
        Assert.assertEquals(accountListPage.getExistPhoneNumberByAccountName(account.getAccountName()), account.getPhone());
        Assert.assertEquals(accountListPage.getExistAccountOwnerByAccountName(account.getAccountName()), "ASh");
    }

    @Test
    public void validateAccountDataTest() {
        Account account1 = new Account();
        account1.setAccountName("account" + random.nextInt(100));
        account1.setWebsite("www");
        account1.setType("Partner");
        account1.setPhone("80291111111");
        account1.setDescription("some description");
        loginPage
                .openPage(LOGIN_URL)
                .login(username, password);
        newAccountModalPage
                .openNewAccountModalPage()
                .createNewAccount(account1);
        accountListPage
                .openPage(ACCOUNT_LIST_URL)
                .clickOnAccountName(account1.getAccountName());
        Assert.assertEquals(accountPage.getFieldValueByName(account1.getAccountName()), account1.getAccountName());
        Assert.assertEquals(accountPage.getFieldValueByName(account1.getWebsite()), account1.getWebsite());
        Assert.assertEquals(accountPage.getFieldValueByName(account1.getType()), account1.getType());
        Assert.assertEquals(accountPage.getFieldValueByName(account1.getDescription()), account1.getDescription());
        Assert.assertEquals(accountPage.getFieldValueByName(account1.getPhone()), account1.getPhone());
    }
}
