package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.R;

public class WalletFragment extends Fragment {
    TextView available_balance, ad_text_one, ad_text_two, ad_text_three,text_dashboard;
    Button button_load_money;
    LinearLayout ad_rectangle;
    ImageView ad_image;

    public WalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_wallet, container, false);
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        available_balance = view.findViewById(R.id.available_balance);
        ad_text_one = view.findViewById(R.id.ad_text_one);
        ad_text_two = view.findViewById(R.id.ad_text_two);
        ad_text_three = view.findViewById(R.id.ad_text_three);
        button_load_money = view.findViewById(R.id.button_load_money);
        ad_rectangle = view.findViewById(R.id.ad_rectangle);
        ad_image = view.findViewById(R.id.ad_image);
        text_dashboard = view.findViewById(R.id.text_dashboard);

        ad_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });

        button_load_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });

        text_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDashboardFragment();
            }
        });

        return view;
    }

    private void goToDashboardFragment() {
        DashboardFragment fragment = new DashboardFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
