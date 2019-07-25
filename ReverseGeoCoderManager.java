
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ReverseGeoCoderManager {
    /**
     * The GeoCoder class requires a backend service that is not included in
     * the core android framework.
     */
    private static Geocoder geocoder = null;

    /**
     * Create the instance
     *
     * @param context represent as context
     * @return
     */
    private Geocoder instanceFromGeoCoder(Context context) {
        if (geocoder == null) {
            // Constructs a GeoCoder whose responses will be localized for the given Locale.
            return new Geocoder(context, Locale.ENGLISH);
        }
        return geocoder;
    }

    /**
     * Method call to get Addresses that are known to describe the area immediately surrounding the given latitude and longitude.
     *
     * @param context                 represent as context
     * @param latitude                represent as latitude a point for the search
     * @param longitude               represent as longitude a point for the search
     * @param locationAddressCallback callback
     */
    public static void getLocationAddressFromGeoCoder(Context context, double latitude, double longitude,
                                                      FRLocationAddressCallback locationAddressCallback) {
        try {
            // https://developer.android.com/reference/android/location/Geocoder
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
            if (geocoder.isPresent() && addresses.size() > 0) {
                Address returnAddress = addresses.get(0);
                if (returnAddress != null) {
                    String countryName = returnAddress.getCountryName();
                    String countryCode = returnAddress.getCountryCode();
                    String addressLine = returnAddress.getAddressLine(0);
                    double locationLatitude = returnAddress.getLatitude();
                    double locationLongitude = returnAddress.getLongitude();
                    if (countryName != null && countryCode != null && addressLine != null && locationLatitude != 0 && locationLongitude != 0) {
                        locationAddressCallback.getFromLocationName(new FRLocationAddress(countryName, countryCode, addressLine, locationLatitude, locationLongitude));
                    } else {
                        locationAddressCallback.onFailure();
                    }
                } else {
                    locationAddressCallback.onFailure();
                }
            } else {
                //  The Geocoder query methods will return an empty list if there no backend service in the platform.
                // isPresent() method to determine whether a Geocoder implementation exists.
                locationAddressCallback.onFailure();
            }
        } catch (IOException e) {
            locationAddressCallback.onFailure();
            Log.e("Location Address From GeoCoder IO Exception caught : ", e.getMessage());
        } catch (Exception e) {
            locationAddressCallback.onFailure();
            Log.e("Location Address From GeoCoder Exception caught : ", e.getMessage());
        }
    }
}