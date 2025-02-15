package utilities.common;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public enum Accounts {
    //
    TEST_FINAN_BOOK("","", "", "", "Hồ Chí Minh", "Quận 12", "Vuon Lai, An phu dong"),
    ;
    private String phoneNumber;
    private String pwd;
    private String otp;
    private String email;
    private String city;
    private String district;
    private String address;

    /**
     * constructor
     */
    private Accounts(String phoneNumber, String pwd, String otp, String email, String city, String district, String address) {
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
        this.otp = otp;
        this.email = email;
        this.city = city;
        this.district = district;
        this.address = address;
    }

    /**
     * getter & setter
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getotp() {
        return otp;
    }
    public void setotp(String otp) {
        this.otp = otp;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
