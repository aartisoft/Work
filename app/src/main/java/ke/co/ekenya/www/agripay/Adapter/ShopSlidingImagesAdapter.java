package ke.co.ekenya.www.agripay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;
import java.util.List;

import ke.co.ekenya.www.agripay.R;

public class ShopSlidingImagesAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public ShopSlidingImagesAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.shop_image_slide, view, false);

        ImageView myImage = myImageLayout.findViewById(R.id.slide_image);

        Glide
                .with(context)
                .load(images.get(position))
                .thumbnail(0.1f)
                .crossFade()
                .into(myImage);

        //myImage.setImageResource(images.get(position));

        view.addView(myImageLayout, 0);

        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}