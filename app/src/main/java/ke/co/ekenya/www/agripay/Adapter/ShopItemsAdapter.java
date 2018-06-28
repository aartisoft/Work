package ke.co.ekenya.www.agripay.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ke.co.ekenya.www.agripay.Fragments.AddToCartFragment;
import ke.co.ekenya.www.agripay.R;


public class ShopItemsAdapter extends RecyclerView.Adapter<ShopItemsAdapter.MyViewHolder> {

    ArrayList<String> itemName;
    ArrayList<Integer> itemImage;
    ArrayList<String> itemPrice;
    ArrayList<String> itemRating;
    ArrayList<String> itemUnit;
    Context context;

    public ShopItemsAdapter(Context context, ArrayList<String> itemName,
                            ArrayList<Integer> itemImage,
                            ArrayList<String> itemPrice,
                            ArrayList<String> itemRating,
                            ArrayList<String> itemUnit) {

        this.context = context;
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.itemRating = itemRating;
        this.itemUnit = itemUnit;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_items_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //set the data in items
        holder.item_price.setText("Kshs." + itemPrice.get(position));
        holder.item_name.setText(itemName.get(position));
        holder.item_unit.setText(itemUnit.get(position));
        holder.item_rating.setRating(Float.parseFloat(itemRating.get(position)));

        //Toast.makeText(context, itemRating.get(position), Toast.LENGTH_SHORT).show();

        Glide
                .with(context)
                .load(itemImage.get(position))
                .crossFade()
                .into(holder.item_image);

        //implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                AddToCartFragment fragmentA = new AddToCartFragment();
                android.support.v4.app.FragmentTransaction fragmentTransactionA = activity.getSupportFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                //key first then value
                bundle.putString("price", itemPrice.get(position));
                bundle.putString("name", itemName.get(position));
                bundle.putString("unit", itemUnit.get(position));
                bundle.putString("rating", itemRating.get(position));

                fragmentA.setArguments(bundle);

                fragmentTransactionA.replace(R.id.content, fragmentA);
                fragmentTransactionA.addToBackStack(null);
                fragmentTransactionA.commit();

            }
        });

    }


    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView item_price;
        ImageView item_image;
        TextView item_name;
        TextView item_unit;
        RatingBar item_rating;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_price = itemView.findViewById(R.id.item_price);
            item_image = itemView.findViewById(R.id.item_image);
            item_name = itemView.findViewById(R.id.item_name);
            item_unit = itemView.findViewById(R.id.item_unit);
            item_rating = itemView.findViewById(R.id.item_rating);

        }
    }
}
