package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.my_interfaces.IClickItemListener;

import java.util.List;

import Model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> proList;
    private IClickItemListener iClickItemListener;

    public ProductAdapter(Context context, IClickItemListener listener) {
        this.context = context;
        this.iClickItemListener = listener;
    }

    public void setData(List<Product> list) {
        this.proList = list;
        notifyDataSetChanged();
    }

    public static int getImageId(Context context, String imageName) {
        Log.e("[IMAGE NAME]", imageName);
        Log.e("[IMAGE INDEX]", context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName()) + "");
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = proList.get(position);
        if (product == null){
            return;
        } else {
            holder.imgProduct.setImageResource(getImageId(context.getApplicationContext(), product.getImg()));
            holder.proName.setText(product.getName());
            holder.proPrice.setText(product.getPrice()+ "");

//            holder.addTocart.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    iClickAddToCart.onClickAddToCart(holder.addTocart, product);
//                }
//            });


            //handle item click show detail
            holder.layoutProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iClickItemListener.onClickProduct(product);
                }
            });
        }
    }




    @Override
    public int getItemCount() {
        if (proList != null) {
            return proList.size();
        }
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private CardView layoutProduct;
        private ImageView imgProduct;
        private TextView proName;
        private TextView proPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutProduct = itemView.findViewById(R.id.layoutProduct);
            imgProduct = itemView.findViewById(R.id.img_product);
            proName = itemView.findViewById(R.id.proName);
            proPrice = itemView.findViewById(R.id.proPrice);
        }
    }

}
