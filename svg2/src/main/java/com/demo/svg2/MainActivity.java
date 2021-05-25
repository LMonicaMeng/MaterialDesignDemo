package com.demo.svg2;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ricky.lsn23_svg.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ImageView iv = (ImageView) findViewById(R.id.iv2);
//        iv.setImageResource(R.drawable.svg_img);
    }

    public void anim1(View v){
        ImageView iv = (ImageView) v;
        Drawable drawable = iv.getDrawable();
        if(drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }
    }
}
