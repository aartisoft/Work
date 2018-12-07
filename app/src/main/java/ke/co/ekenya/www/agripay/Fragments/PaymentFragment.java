package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import ke.co.ekenya.www.agripay.R;

public class PaymentFragment extends Fragment {
    ImageView back, shop_cart;
    Button button_check_out;
    RadioButton credit_card_radio, m_pesa_radio, cash_on_delivery_radio, my_wallet_radio;
    String checked = "N/A";

    public PaymentFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        back = view.findViewById(R.id.back);
        shop_cart = view.findViewById(R.id.shop_cart);
        button_check_out = view.findViewById(R.id.button_check_out);
        credit_card_radio = view.findViewById(R.id.credit_card_radio);
        m_pesa_radio = view.findViewById(R.id.m_pesa_radio);
        cash_on_delivery_radio = view.findViewById(R.id.cash_on_delivery_radio);
        my_wallet_radio = view.findViewById(R.id.my_wallet_radio);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        credit_card_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set string to show correct next fragment
                checked = "card";
            }
        });

        m_pesa_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set string to show correct next fragment
                checked = "mpesa";
            }
        });

        button_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check which radio button is selected
                switch (checked) {
                    case "card":
                        goToCardPaymentDetails();
                        break;
                    case "mpesa":
                        goToMpesaPaymentDetails();
                        break;
                    default:
                        showNotAvailable();
                        break;
                }
            }
        });

        return view;
    }

    private void showNotAvailable() {
        //show toast that those options aren't available
        Toast.makeText(getContext(), "Not available at the moment", Toast.LENGTH_LONG).show();
    }

    private void goToCardPaymentDetails() {
        CardPaymentDetailsFragment fragment = new CardPaymentDetailsFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void goToMpesaPaymentDetails() {
        MpesaPaymentDetailsFragment fragment = new MpesaPaymentDetailsFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
