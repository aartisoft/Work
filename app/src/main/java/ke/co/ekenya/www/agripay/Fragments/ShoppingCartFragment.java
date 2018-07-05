package ke.co.ekenya.www.agripay.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ke.co.ekenya.www.agripay.R;

public class ShoppingCartFragment extends Fragment {
    ImageView back, shop_cart;
    Button button_add_to_cart;

    public ShoppingCartFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        back = view.findViewById(R.id.back);
        button_add_to_cart = view.findViewById(R.id.button_add_to_cart);
        shop_cart = view.findViewById(R.id.shop_cart);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        button_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddresses();
            }
        });

        shop_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToShoppingCartFragment();
            }
        });

        return view;

    }

    private void goToShoppingCartFragment() {
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void goToAddresses() {
        AddressesFragment fragment = new AddressesFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
