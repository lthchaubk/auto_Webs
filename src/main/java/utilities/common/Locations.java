package utilities.common;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public enum Locations {
    DISTRICT_3("Hồ Chí Minh", "Quận 3", "", 10.7835291, 106.6870984), // => this is local location (main location to check)
    ;

    private String city;
    private String district;
    private String address;
    private double districtLat;
    private double districtLong;

    private Locations(String city, String district, String address, double districtLat, double districtLong) {
        this.city = city;
        this.district = district;
        this.address = address;
        this.districtLat = districtLat;
        this.districtLong = districtLong;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getAddress() {
        return this.address;
    }

    public double getDistrictLat() {
        return this.districtLat;
    }

    public double getDistrictLong() {
        return this.districtLong;
    }
}
