package com.example.student.LoadImage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);

        ImageRequest request1=new ImageRequest("http://images.parents.mdpcdn.com/sites/parents.com/files/styles/width_300/public/images/p_101395269.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView iv1=(ImageView)findViewById(R.id.iv1);
                        iv1.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request1);
        queue.start();

        ImageView iv2=(ImageView)findViewById(R.id.iv2);
        Picasso.with(this)
                .load("https://thumb1.shutterstock.com/display_pic_with_logo/3138983/499778260/stock-vector-cartoon-ladybug-vector-illustration-cute-red-ladybug-isolated-in-a-flat-style-499778260.jpg")
                .into(iv2);
    }
}
