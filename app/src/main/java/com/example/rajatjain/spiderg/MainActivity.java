package com.example.rajatjain.spiderg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "SIRI"
    };
    String[] videoId={
            "bqquLiEiLPc",
            "Onlfgupr2OY",
            "E3jhQZWRnXc",
            "UE4czKiZDsk",
            "FgV8-At7M4w",
            "jnOqCt9rkd0"
    };
    Integer[][] imgId={{
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4

    },
            {
                    R.drawable.sample_5,
                    R.drawable.sample_6,
                    R.drawable.sample_7,
                    R.drawable.sample_8
            },
            {
                    R.drawable.sample_9,
                    R.drawable.sample_10,
                    R.drawable.sample_11,
                    R.drawable.sample_12
            },
            {
                    R.drawable.sample_13,
                    R.drawable.sample_14,
                    R.drawable.sample_15,
                    R.drawable.sample_16
            },
            {
                    R.drawable.sample_17,
                    R.drawable.sample_18,
                    R.drawable.sample_19,
                    R.drawable.sample_20
            },
            {
                    R.drawable.sample_21,
                    R.drawable.sample_22,
                    R.drawable.sample_23,
                    R.drawable.sample_24
            },

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, videoId,imgId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

    }
}
