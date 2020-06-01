package com.gabrieldeespindula.festafimdeano.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gabrieldeespindula.festafimdeano.Constants.FimDeAnoConstants;
import com.gabrieldeespindula.festafimdeano.Data.SecurityPreferences;
import com.gabrieldeespindula.festafimdeano.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonYesNo = findViewById(R.id.button_yes_no);

        this.mViewHolder.buttonYesNo.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));
        this.mViewHolder.textDaysLeft.setText(daysLeft);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.VerifyPresence();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_yes_no){
            String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRECENSE_KEY);
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.CONFIRMATION_YES, presence);
            startActivity(intent);
        }
    }

    private void VerifyPresence() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRECENSE_KEY);
        if (presence.equals("")){
            this.mViewHolder.buttonYesNo.setText(getString(R.string.nao_confirmado));
        }else if (presence.equals(FimDeAnoConstants.CONFIRMATION_YES)){
            this.mViewHolder.buttonYesNo.setText(getString(R.string.sim));
        } else {
            this.mViewHolder.buttonYesNo.setText(getString(R.string.nao));
        }
    }

    private int getDaysLeft(){
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        Calendar calendarLastDay = Calendar.getInstance();
        int lastDay = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return lastDay - today;
    }


    private static class ViewHolder {
        TextView textToday;
        TextView textDaysLeft;
        Button buttonYesNo;
    }
}
