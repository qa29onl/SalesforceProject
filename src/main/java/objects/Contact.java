package objects;

public class Contact {
    private String salutation;
    private String firstName;
    private String lastName;
    private String phone;
    private String mobile;
    private String accountName;
    private String email;

    public Contact() {
    }

    public Contact(String salutation, String firstName, String lastName, String phone, String mobile, String accountName, String email) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mobile = mobile;
        this.accountName = accountName;
        this.email = email;
    }

    public String getSalutation() {
        return salutation;
    }

    public Contact setSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Contact setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public Contact setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }
}
