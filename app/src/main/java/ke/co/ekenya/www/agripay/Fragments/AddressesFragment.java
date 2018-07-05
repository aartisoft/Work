package ke.co.ekenya.www.agripay.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.www.agripay.R;

public class AddressesFragment extends Fragment {
    ImageView back, shop_cart;
    Button button_proceed_to_payment;

    public AddressesFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_addresses, container, false);

        back = view.findViewById(R.id.back);
        button_proceed_to_payment = view.findViewById(R.id.button_proceed_to_payment);
        shop_cart = view.findViewById(R.id.shop_cart);

        button_proceed_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentFragment();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        shop_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentFragment();
            }
        });

        return view;
    }

    private void goToPaymentFragment() {
        PaymentFragment fragment = new PaymentFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
