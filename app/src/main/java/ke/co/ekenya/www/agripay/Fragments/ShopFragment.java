package ke.co.ekenya.www.agripay.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Arrays;

import ke.co.ekenya.www.agripay.Adapter.ShopItemsAdapter;
import ke.co.ekenya.www.agripay.R;

public class ShopFragment extends Fragment {

    static ArrayList<String> itemName = new ArrayList<>(Arrays.asList("Red Onion",
            "Tomato",
            "Broccoli",
            "Red Chilly",
            "Carrot",
            "Red Onion",
            "Red Chilly",
            "Carrot"));

    static ArrayList<Integer> itemImage = new ArrayList<>(Arrays.asList(R.drawable.onion,
            R.drawable.tomato,
            R.drawable.broccoli,
            R.drawable.chilli,
            R.drawable.carrot,
            R.drawable.onion,
            R.drawable.chilli,
            R.drawable.carrot));

    static ArrayList<String> itemPrice = new ArrayList<>(Arrays.asList("5",
            "10",
            "20",
            "3",
            "4",
            "4",
            "10",
            "30"));

    static ArrayList<String> itemRating = new ArrayList<>(Arrays.asList("4.5",
            "1.0",
            "2.0",
            "3.0",
            "4.0",
            "5.0",
            "3.0",
            "2.0"));

    static ArrayList<String> itemUnit = new ArrayList<>(Arrays.asList("each",
            "for every three",
            "each",
            "for every two",
            "each",
            "for every five",
            "each",
            "each"));

    CarouselView carouselView;

    int[] sliding_images_array = {R.drawable.shop_image_slide_one,
            R.drawable.shop_image_slide_two,
            R.drawable.shop_image_slide_three};

    RecyclerView shop_items_recycler_view;
    ImageView shop_cart;

    public ShopFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        shop_items_recycler_view = view.findViewById(R.id.shop_items_recycler_view);
        carouselView = view.findViewById(R.id.sliding_images);
        shop_cart = view.findViewById(R.id.shop_cart);

        shop_items_recycler_view.setLayoutManager(new GridLayoutManager(getContext(), 2));

        ShopItemsAdapter customAdapter = new ShopItemsAdapter(getActivity(), itemName, itemImage, itemPrice, itemRating, itemUnit);
        shop_items_recycler_view.setAdapter(customAdapter);

        initializeSlidingImages();

        shop_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
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

    private void initializeSlidingImages() {
        carouselView.setPageCount(sliding_images_array.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                Glide
                        .with(getActivity())
                        .load(sliding_images_array[position])
                        .crossFade()
                        .into(imageView);
            }
        });
    }

}
