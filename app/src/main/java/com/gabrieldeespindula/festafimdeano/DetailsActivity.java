package com.gabrieldeespindula.festafimdeano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_box_participate);
    }

    private class ViewHolder {
        CheckBox checkParticipate;
    }
}
