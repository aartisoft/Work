package ke.co.ekenya.www.agripay.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import ke.co.ekenya.www.agripay.Adapter.ShopItemsAdapter;
import ke.co.ekenya.www.agripay.Adapter.ShopSlidingImagesAdapter;
import ke.co.ekenya.www.agripay.R;
import me.relex.circleindicator.CircleIndicator;

public class ShopFragment extends Fragment {
    private ViewPager mPager;
    CircleIndicator indicator;
    private static int currentPage = 0;
    private static final Integer[] SlidingImages = {R.drawable.shop_image_slide_one,
            R.drawable.shop_image_slide_two,
            R.drawable.shop_image_slide_three};
    private ArrayList<Integer> SlidingImagesArray = new ArrayList<Integer>();

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

    RecyclerView shop_items_recycler_view;

    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_shop, container, false);

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        mPager = view.findViewById(R.id.slide_pager);
        indicator = view.findViewById(R.id.slide_indicator);
        shop_items_recycler_view = view.findViewById(R.id.shop_items_recycler_view);

        //StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        shop_items_recycler_view.setLayoutManager(new GridLayoutManager(getContext(),2 ));

        ShopItemsAdapter customAdapter = new ShopItemsAdapter(getActivity(), itemName, itemImage, itemPrice, itemRating, itemUnit);

        shop_items_recycler_view.setAdapter(customAdapter);

        initializeSlidingImages();

        return view;
    }

    private void initializeSlidingImages() {
        SlidingImagesArray.addAll(Arrays.asList(SlidingImages));

        mPager.setAdapter(new ShopSlidingImagesAdapter(getActivity(), SlidingImagesArray));
        assert indicator != null;
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == SlidingImages.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 3000);

    }

}
