package ru.puchkova.homework41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView money, info;
    private CheckBox card, phone, cash;
    private Button ok;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();



    }

    private void initViews(){
        money = (TextView) findViewById(R.id.money);
        info = (TextView) findViewById(R.id.info);
        card = (CheckBox) findViewById(R.id.card);
        phone = (CheckBox) findViewById(R.id.phone);
        cash = (CheckBox) findViewById(R.id.cash);
        ok = (Button) findViewById(R.id.ok);
        card.setOnCheckedChangeListener(checked);
        phone.setOnCheckedChangeListener(checked);
        cash.setOnCheckedChangeListener(checked);
        ok.setOnClickListener(oclOk);
        resetChecks();
    }

    private void resetChecks(){
        card.setChecked(false);
        phone.setChecked(false);
        cash.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checked = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                info.setText("");
                switch (buttonView.getId()){
                    case R.id.card:
                        resetChecks();
                        card.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_NUMBER);
                        text = "Выбрана оплата банковской картой.";
                        break;
                    case R.id.phone:
                        resetChecks();
                        phone.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_PHONE);
                        text = "Выбрана оплата с мобильного телефона.";
                        break;
                    case R.id.cash:
                        resetChecks();
                        cash.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_TEXT);
                        text = "Выбрана оплата наличными.";
                        break;
                }
            }
        }
    };

    View.OnClickListener oclOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        }
    };
}
