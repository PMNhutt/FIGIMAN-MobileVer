package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.my_interfaces.ICartItemListener;

import java.util.List;

import Model.Cart;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private Context context;
    public List<Cart> cartList;
    public ICartItemListener iCartItemListener;

    public CartAdapter(Context context, ICartItemListener iCartItemListener) {
        this.context = context;
        this.iCartItemListener = iCartItemListener;
    }

    public CartAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Cart> list) {
        this.cartList = list;
        notifyDataSetChanged();
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new CartAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        if (cart == null){
            return;
        } else {
//            holder.imgCart.setImageResource(getImageId(context.getApplicationContext(), cart.getImg()));
//            holder.proName.setText(cart.getProductName());
//            holder.quantity.setText(cart.getQuantity()+ "");
            holder.setData(cart, position);
        }
    }

    @Override
    public int getItemCount() {
        if (cartList != null) {
            return cartList.size();
        }
        return 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        private CardView layoutCart;
        private ImageView imgCart;
        private TextView proName;
        private TextView quantity;
        private ImageView deleteBtn;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutCart = itemView.findViewById(R.id.layoutCart);
            imgCart = itemView.findViewById(R.id.img_cart);
            proName = itemView.findViewById(R.id.item_name);
            quantity = itemView.findViewById(R.id.tvQuantity);
            deleteBtn = itemView.findViewById(R.id.deleteCart);

        }

        public void setData (Cart cart, int position) {
            imgCart.setImageResource(getImageId(context.getApplicationContext(), cart.getImg()));
            proName.setText(cart.getProductName());
            quantity.setText(cart.getQuantity()+ "");
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iCartItemListener.DeleteCart(position);
                }
            });
        }
    }
}