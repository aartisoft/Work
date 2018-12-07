package ke.co.ekenya.www.agripay.Connectors;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ApiConnector {
    //used to check whether user already exists in database before beginning registration
    public String MpesaSTKPush(int mobileNo) {
        StringBuilder result = new StringBuilder();
        HttpsURLConnection urlConnection = null;
        String response = null;

        try {
            URL url = new URL("https://www.snugjar.com/Apps/MPESA/myCheckout.php?mobile_no=" + mobileNo);
            urlConnection = (HttpsURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            in.close();
            reader.close();

            response = String.valueOf(result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return response;

    }
}
