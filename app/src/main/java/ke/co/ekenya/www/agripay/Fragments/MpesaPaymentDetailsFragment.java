package ke.co.ekenya.www.agripay.Fragments;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ke.co.ekenya.www.agripay.Connectors.ApiConnector;
import ke.co.ekenya.www.agripay.R;

public class MpesaPaymentDetailsFragment extends Fragment {

    EditText mobile_number;
    Button button_pay;
    String mobile = "N/A";
    int mobile_no;

    public MpesaPaymentDetailsFragment() {
        //Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mpesa_payment_details, container, false);

        mobile_number = view.findViewById(R.id.mobile_number);
        button_pay = view.findViewById(R.id.button_pay);

        button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get mobile number and send to server for push notification to come through
                mobile = mobile_number.getText().toString();
                mobile_no = Integer.parseInt(mobile);

                if (mobile_no > 10) {
                    new SendSTKPush().execute(new ApiConnector());
                } else {
                    Toast.makeText(getContext(), "Mobile Number Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    @SuppressLint("StaticFieldLeak")
    private class SendSTKPush extends AsyncTask<ApiConnector, Long, String> {
        @Override
        protected String doInBackground(ApiConnector... params) {
            //it is executed on Background thread
            return params[0].MpesaSTKPush(mobile_no);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String response) {
            try {
                //check responses from the server
                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();

                /*if (Objects.equals(response, "Exist")) {
                    //user already in database, proceed to main
                    goToMain();
                } else {
                    //user absent in database, confirm details first
                    displayConfirmDialog();
                }*/

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
