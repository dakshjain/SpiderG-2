package com.example.rajatjain.spiderg;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Random;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] vidid;
    private final Integer[][] imgId;
    ArrayList<TextView> arrayList  =new ArrayList<>();

    public CustomListAdapter(Activity context, String[] itemname, String[] vidid,Integer[][] imgId) {
        super(context, R.layout.mylist, itemname);

        this.context = context;
        this.itemname = itemname;
        this.vidid = vidid;
        this.imgId = imgId;
    }

    public View getView(final int position, View view, final ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.text);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.icon2);
        ImageView imageView3= (ImageView) rowView.findViewById(R.id.icon3);
        ImageView imageView4 = (ImageView) rowView.findViewById(R.id.icon4);
        TextView tv[] = new TextView[5];
        RelativeLayout relativelayout=(RelativeLayout)rowView.findViewById(R.id.relative_layout);
        LinearLayout scroll_layout = (LinearLayout)rowView.findViewById(R.id.scroll_linear);
        txtTitle.setText(itemname[position]);
        Picasso.with(parent.getContext())
                .load(imgId[position][0])
                .resize(300,300)
                .into(imageView);
        Picasso.with(parent.getContext())
                .load(imgId[position][1])
                .resize(300,300)
                .into(imageView2);
        Picasso.with(parent.getContext())
                .load(imgId[position][2])
                .resize(300,300)
                .into(imageView3);
        Picasso.with(parent.getContext())
                .load(imgId[position][3])
                .resize(300,300)
                .into(imageView4);
        scroll_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.getContext().startActivity(new Intent(parent.getContext(),VideoPlayer.class).putExtra("videoid",vidid[position]));

            }
        });

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        for (int i = 0; i < 5; i++) {
            tv[i] = new TextView(parent.getContext());
            params.setMargins(getRandomPosition(), getRandomPosition(), 0, 0);
            tv[i].setLayoutParams(params);
            tv[i].setX(getRandomPosition());
            tv[i].setY(getRandomPosition());
            tv[i].setTextSize(12);
            tv[i].setText("Text"+i);
            relativelayout.addView(tv[i]);
        }
        return rowView;
    }
    private int getRandomPosition() {
        Random r = new Random();
        int x= r.nextInt(250);
        return x;

    }


}