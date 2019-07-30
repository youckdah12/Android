package com.cookandroid.v4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

     TextView toastText;
     View toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");


        Gallery gallery=(Gallery) findViewById(R.id.gallery1);


        MyGalleryAdapter galAdapter=new  MyGalleryAdapter(this);
        gallery.setAdapter(galAdapter);
    }
    public class MyGalleryAdapter extends BaseAdapter{
        Context context;
        Integer[] posterID={R.drawable.mov11,R.drawable.mov12,R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,R.drawable.mov19,R.drawable.mov20};

        String[] posterName={"가","나","가","나","가","나","가","나","가","나"};

        public MyGalleryAdapter(Context c){
            context=c;
        }
        public int getCount(){
            return posterID.length;
        }
        public Object getItem(int arg0){

            return null;
        }

        public long getItemId(int position){
            return 0;
        }

        public View getView(int position, View converView, ViewGroup parent){
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new Gallery.LayoutParams(100,150));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
            imageView.setImageResource(posterID[position]);
            final int pos=position;
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    ImageView ivPoster=(ImageView) findViewById(R.id.ivPoster);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivPoster.setImageResource(posterID[pos]);

                    Toast toast=new Toast(getApplicationContext());
                    toastView=(View) View.inflate(getApplicationContext(),R.layout.ima,null);
                    toastText =(TextView) toastView.findViewById(R.id.toastText1);
                    toastText.setText(posterName[pos]);
                    toast.setView(toastView);
                    toast.show();
                    return false;
                }
            });

            return imageView;
        }
    }
}
