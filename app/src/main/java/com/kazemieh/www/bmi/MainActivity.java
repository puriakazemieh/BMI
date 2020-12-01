package com.kazemieh.www.bmi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_result = findViewById(R.id.b_MainActivity_result);
        final EditText et_qad = findViewById(R.id.et_MainActivity_qad);
        final EditText et_vazn = findViewById(R.id.et_MAinActivity_vazn);
        final TextView tv_rsult = findViewById(R.id.tv_MainActivity_result);
        final TextView tv_if = findViewById(R.id.tv_MainActivity_if);
        final ImageView iv_bmi=findViewById(R.id.iv_MainActivity_bmi);

        b_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s_qad = et_qad.getText().toString();
                String s_vazn = et_vazn.getText().toString();

                if (!s_qad.equals("") && !s_vazn.equals("")){

                    int i_qad = Integer.parseInt(s_qad);
                    int i_vazn = Integer.parseInt(s_vazn);

                    float f_qad = i_qad * i_qad;
                    float f_result = i_vazn / f_qad;
                    float result = f_result * 10000;

                    //  Toast.makeText(getApplicationContext(),f_result+"",Toast.LENGTH_LONG).show();
                    tv_rsult.setText(result + "");

                    if (result < 18.5) {
                        iv_bmi.setImageResource(R.drawable.bmi1);
                        tv_if.setText("شما کمبود وزن دارید");
                    } else if (result > 18.5 && result < 24.9) {
                        iv_bmi.setImageResource(R.drawable.bmi2);
                        tv_if.setText("طبیعی");
                    } else if (result > 25 && result < 29.9) {
                        iv_bmi.setImageResource(R.drawable.bmi3);
                        tv_if.setText("شما اضافه وزن دارید");
                    } else if (result > 30) {
                        iv_bmi.setImageResource(R.drawable.bmi4);
                        tv_if.setText("شما چاق هستید");
                    }
                }else {
                    Toast.makeText(getApplicationContext(),"لطفا مقادیر را پر کنید",Toast.LENGTH_LONG).show();
                }



            }
        });

    }
}
