package tests;

import objects.Account;
import objects.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ContactTest extends BaseTest {
    Random random = new Random();

    @Test
    public void createContactTest() throws InterruptedException {
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

        Contact contact1 = new Contact();
        contact1
                .setFirstName("1" + random.nextInt(100))
                .setLastName("2" + random.nextInt(100))
                .setPhone("37517" + random.nextInt(100))
                .setMobile("375" + random.nextInt(100))
                .setEmail("111@gmail.com" + random.nextInt(100))
                .setSalutation("Ms.")
                .setAccountName(account.getAccountName());
        newContactModalPage
                .openNewContactModalPage()
                .createNewContact(contact1);
        contactListPage
                .openPage(CONTACTS_LIST_URL);
        Assert.assertEquals(contactListPage.getExistPhoneNumber(contact1.getPhone()),contact1.getPhone());
        Assert.assertEquals(contactListPage.getExistContactName("1", "2"),"1 2");
    }
}
