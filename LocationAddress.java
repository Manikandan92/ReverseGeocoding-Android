
public class LocationAddress {
    private String countryName;
    private String countryCode;
    private String locationName;
    private double locationLatitude;
    private double locationLongitude;

    /**
     * Constructs a Location address
     *
     * @param countryName       represent as country name
     * @param countryCode       represent as country code
     * @param locationName      represent as location name
     * @param locationLatitude  represent as location latitude
     * @param locationLongitude represent as location longtitude
     */
    public LocationAddress(String countryName, String countryCode, String locationName, double locationLatitude, double locationLongitude) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.locationName = locationName;
        this.locationLatitude = locationLatitude;
        this.locationLongitude = locationLongitude;
    }

    /**
     * Method call to get country name
     *
     * @return
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Method call to get country code
     *
     * @return
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Method call to get Location address name
     *
     * @return
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Method call to get location latitude
     *
     * @return
     */
    public double getLocationLatitude() {
        return locationLatitude;
    }

    /**
     * Method call to get location longitude
     *
     * @return
     */
    public double getLocationLongitude() {
        return locationLongitude;
    }
}