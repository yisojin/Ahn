package kr.hs.dgsw.flow.Common;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import kr.hs.dgsw.flow.R;

public class Adapter extends PagerAdapter {

    Context context;
    private int[] images = {R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3};

    private LayoutInflater inflater;

    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.slide, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.image_container);
        imageView.setImageResource(images[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout)object;
    }
}
