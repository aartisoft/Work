package ke.co.ekenya.www.agripay.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import ke.co.ekenya.www.agripay.R;

public class AddToCartFragment extends Fragment {
    TextView text_rating, item_name, item_total_cost, item_count, item_price;
    ImageView item_image, item_content_remove, item_content_add, shop_cart;
    Button button_add_to_cart;
    String SPrice, SName, SUnit, SRating;
    int intPrice, intCount, intTotal, intImage;

    public AddToCartFragment() {
        //Required empty public constructor
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
        shop_cart = view.findViewById(R.id.shop_cart);

        assert getArguments() != null;
        SPrice = getArguments().getString("price");
        SName = getArguments().getString("name");
        SUnit = getArguments().getString("unit");
        SRating = getArguments().getString("rating");
        intImage = getArguments().getInt("image");

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

        item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                openGallery();
            }
        });

        button_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToShoppingCartFragment();
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
        //opening shopping cart fragment
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void openGallery() {
        //starting image gallery fragment
        GalleryFragment fragment = new GalleryFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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

        Glide
                .with(getActivity())
                .load(intImage)
                .crossFade()
                .into(item_image);

    }


}
