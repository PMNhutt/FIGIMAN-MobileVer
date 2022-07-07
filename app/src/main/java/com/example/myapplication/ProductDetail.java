package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.fragments.CartFragment;
import com.example.myapplication.fragments.HomeFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Model.Product;

public class ProductDetail extends AppCompatActivity {

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImg = findViewById(R.id.detailImg);
        TextView productName = findViewById(R.id.detailName);
        TextView productPrice = findViewById(R.id.detailPrice);
        TextView productDescription = findViewById(R.id.detailDescription);
        TextView productStockNum = findViewById(R.id.detailStockNum);
        TextView productCategory = findViewById(R.id.detailCategories);
        TextView productCompany = findViewById(R.id.detailComnayName);
        TextView productMaterial = findViewById(R.id.detailMaterial);
        TextView productSize = findViewById(R.id.detailSize);


        FloatingActionButton goBackBtn = findViewById(R.id.detailGoback);
        FloatingActionButton callBtn = findViewById(R.id.detailCalling);
        MaterialButton addToCartBtn = findViewById(R.id.detailAddToCart);

        //get product data on click
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }

        Product pro = (Product) bundle.get("product_data");
        //set data to detail
        productImg.setImageResource(getImageId(this, pro.getImg()));
        productName.setText(pro.getName());
        productPrice.setText(pro.getPrice() + "");
        productDescription.setText(pro.getDescription());
        productStockNum.setText(pro.getQuantity() + "");
        productCategory.setText(pro.getCategory());
        productCompany.setText(pro.getCompany());
        productMaterial.setText(pro.getMaterial());
        productSize.setText(pro.getSize());

        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String phoneNum = "0988675463";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNum));
                startActivity(intent);
            }
        });

        //add to cart (push notification)
        Intent cartView = new Intent(this, Register.class);
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String CHANNEL_ID = "chanel_id";
                CharSequence name= "chanel_name";

                Context context = getApplicationContext();
                int important = NotificationManager.IMPORTANCE_MIN;
                PendingIntent pe = PendingIntent.getActivity(getApplicationContext(), 0 ,cartView, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.figiman_logo)
                        .setContentTitle("FIGIMAN")
                        .setContentText("You have a new product in your cart")
                        .setChannelId(CHANNEL_ID)
                        .setContentIntent(pe)
                        .setAutoCancel(true)
                        .build();
                NotificationManager manager = (NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel mychannel = new NotificationChannel(CHANNEL_ID, name, important);
                    manager.createNotificationChannel(mychannel);
                }
                manager.notify(0, builder);
            }
        });
    }
}