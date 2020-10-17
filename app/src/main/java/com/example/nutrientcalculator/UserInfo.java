package com.example.nutrientcalculator;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class UserInfo extends AppCompatActivity {

    public TextView save,bmi_disp,req_wt;
    public CardView cardView;
    public boolean saves=true;
    private EditText ht,wt;
    private EditText age;
    private CheckBox m,f;
    public int hgt;
    public int wgt;
    public int ag;
    public float fbmi,hgts,wtmin,wtmax;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        save=(TextView) findViewById(R.id.textView4);
        cardView=(CardView)findViewById(R.id.info_card);
        ht=(EditText)findViewById(R.id.edit_height);
        wt=(EditText)findViewById(R.id.edit_weight);
        age=(EditText)findViewById(R.id.edit_age);
        m=findViewById(R.id.male);
        f=findViewById(R.id.female);
        bmi_disp=findViewById(R.id.bmi);
        req_wt=findViewById(R.id.req_wt);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ag=Integer.parseInt(age.getText().toString().trim());
                hgt=Integer.parseInt(ht.getText().toString().trim());
                wgt=Integer.parseInt(wt.getText().toString().trim());
                if(ag>14 && ag<65 && hgt>130 && hgt<210 && wgt>30 && wgt<110){
                    float fbmi=wgt;
                    float hgts=hgt/100;
                    hgts=hgts*hgts;
                    fbmi=fbmi/hgts;

                    float wtmin=1,wtmax=1;
                    wtmin=18*hgts;
                    wtmax=24*hgts;



                } else {
                    String s= "Invalid Information";
                    Toast.makeText(UserInfo.this,s,Toast.LENGTH_SHORT).show();
                    saves=false;
                }

                if(saves){
                    String p = Float.toString(fbmi);
                    String pfin = "BMI : "+p;
                    String r = Float.toString(wtmin);
                    String t = Float.toString(wtmax);
                    String range = "Ideal Weight:"+r+"-"+t;
                    bmi_disp.setText(pfin);
                    req_wt.setText(range);
                    cardView.setVisibility(View.VISIBLE);
                    saves=false;
                }
                else {
                    cardView.setVisibility(View.GONE);
                    saves=true;
                }

            }
        });
    }
}
