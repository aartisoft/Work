package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.www.agripay.R;

public class PaymentFragment extends Fragment {
    ImageView back, shop_cart;
    Button button_check_out;

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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        button_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentDetails();
            }
        });

        return view;
    }

    private void goToPaymentDetails() {
        PaymentDetailsFragment fragment = new PaymentDetailsFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
