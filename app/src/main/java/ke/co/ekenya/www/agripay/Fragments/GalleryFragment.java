package ke.co.ekenya.www.agripay.Fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import ke.co.ekenya.www.agripay.R;

public class GalleryFragment extends Fragment {
    ArrayList<Integer> images_array;

    @BindView(R.id.gallery_pager)
    ViewPager main_image_pager;
    @BindView(R.id.thumbnails)
    LinearLayout thumbnails_layout;
    @BindView(R.id.btn_close)
    ImageView image_closeButton;

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_gallery, container, false);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ButterKnife.bind(Objects.requireNonNull(getActivity()));
        }

        main_image_pager = view.findViewById(R.id.gallery_pager);
        image_closeButton = view.findViewById(R.id.btn_close);
        thumbnails_layout = view.findViewById(R.id.thumbnails);

        images_array = new ArrayList<>();
        images_array.add(R.drawable.broccoli);
        images_array.add(R.drawable.broccoli2);
        images_array.add(R.drawable.broccoli3);

        GalleryPagerAdapter gallery_adapter = new GalleryPagerAdapter(getActivity());
        main_image_pager.setAdapter(gallery_adapter);
        main_image_pager.setOffscreenPageLimit(10); //how many images to load into memory

        image_closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    Objects.requireNonNull(getActivity()).onBackPressed();
                }
            }
        });
        return view;
    }

    class GalleryPagerAdapter extends PagerAdapter {
        Context _context;
        LayoutInflater _inflater;

        GalleryPagerAdapter(Context context) {
            _context = context;
            _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images_array.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            View itemView = _inflater.inflate(R.layout.pager_gallery_item, container, false);
            container.addView(itemView);

            //Set the thumbnail layout parameters. Adjust as required
            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(150, 150);
            params.setMargins(30, 0, 30, 0);

            final ImageView thumbView = new ImageView(_context);
            thumbView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            thumbView.setPadding(15, 15, 15, 15);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                thumbView.setBackground(getResources().getDrawable(R.drawable.card_gradient_shade2));
            }

            thumbView.setLayoutParams(params);
            thumbView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Set the pager position when thumbnail clicked
                    main_image_pager.setCurrentItem(position);

                    ViewGroup.LayoutParams params1 = thumbView.getLayoutParams();
                    params1.height = 170;
                    params1.width = 170;
                    thumbView.setLayoutParams(params1);

                }
            });

            thumbnails_layout.addView(thumbView);

            final SubsamplingScaleImageView imageView = itemView.findViewById(R.id.image);

            //Asynchronously load the image and set the thumbnail and pager view
            Glide.with(_context)
                    .load(images_array.get(position))
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                            imageView.setImage(ImageSource.bitmap(bitmap));
                            thumbView.setImageBitmap(bitmap);
                        }
                    });

            return itemView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout) object);
        }
    }

}
