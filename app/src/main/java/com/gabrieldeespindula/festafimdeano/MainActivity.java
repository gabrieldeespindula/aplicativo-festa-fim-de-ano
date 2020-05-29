package com.gabrieldeespindula.festafimdeano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonYesNo = findViewById(R.id.button_yes_no);

        this.mViewHolder.buttonYesNo.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_yes_no){
            Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
            startActivity(intent);
        }
    }


    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonYesNo;
    }
}
