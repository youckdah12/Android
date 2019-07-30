package com.cookandroid.test3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class imageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Integer> mThumbids= null;

    public imageAdapter(Context c,ArrayList<Integer> mThumbids)
    {
        mContext= c;
        this.mThumbids =mThumbids;
    }

    @Override
    public int getCount() {
        return mThumbids.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ImageView i =new ImageView(mContext);
        i.setImageResource(mThumbids.get(position));
        i.setLayoutParams(new Gallery.LayoutParams(400,400));
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        return i;
    }
}
