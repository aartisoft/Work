package ke.co.ekenya.www.agripay.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ke.co.ekenya.www.agripay.R;

public class AddToCartFragment extends Fragment {
    TextView text_rating, item_name, item_total_cost, item_count, item_price;
    ImageView item_image, item_content_remove, item_content_add;
    Button button_add_to_cart;
    String SPrice, SName, SUnit, SRating;
    int intPrice, intCount, intTotal;

    public AddToCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_to_cart, container, false);
        View view = inflater.inflate(R.layout.fragment_add_to_cart, container, false);

        text_rating = view.findViewById(R.id.text_rating);
        item_name = view.findViewById(R.id.item_name);
        item_total_cost = view.findViewById(R.id.item_total_cost);
        item_count = view.findViewById(R.id.item_count);
        item_price = view.findViewById(R.id.item_price);
        item_image = view.findViewById(R.id.item_image);
        item_content_remove = view.findViewById(R.id.item_content_remove);
        item_content_add = view.findViewById(R.id.item_content_add);
        button_add_to_cart = view.findViewById(R.id.button_add_to_cart);

        assert getArguments() != null;
        SPrice = getArguments().getString("price");
        SName = getArguments().getString("name");
        SUnit = getArguments().getString("unit");
        SRating = getArguments().getString("rating");

        initialize();

        item_content_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                addUnit();
            }
        });

        item_content_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                removeUnit();
            }
        });

        return view;
    }

    private void addUnit() {
        String itemCount2 = item_count.getText().toString();

        intCount = Integer.parseInt(itemCount2);

        intCount = intCount + 1;

        item_count.setText(String.valueOf(intCount));

        intTotal = intPrice * intCount;

        item_total_cost.setText("cost " + String.valueOf(intTotal));
    }

    private void removeUnit() {
        String itemCount2 = item_count.getText().toString();

        intCount = Integer.parseInt(itemCount2);

        if (intCount != 1) {
            intCount = intCount - 1;

            item_count.setText(String.valueOf(intCount));

            intTotal = intPrice * intCount;

            item_total_cost.setText("cost " + String.valueOf(intTotal));
        }
    }

    private void initialize() {
        item_count.setText("1");
        item_name.setText(SName);
        item_price.setText("Kshs." + SPrice + " " + SUnit);
        text_rating.setText(SRating);

        intCount = Integer.parseInt(item_count.getText().toString());

        intPrice = Integer.parseInt(SPrice);

        intTotal = intPrice * intCount;

        item_total_cost.setText("cost " + String.valueOf(intTotal));
    }


}
