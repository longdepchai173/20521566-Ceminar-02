package com.example.a20521566ceminar02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    Button calculator;
    EditText num1, num2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        container = findViewById(R.id.container);
        calculator = findViewById(R.id.calculator);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        registerForContextMenu(calculator);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //if (v == btn) {
        getMenuInflater().inflate(R.menu.option, menu);
        //}
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.red:
                container.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.blue:
                container.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case R.id.yellow:
                container.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.white:
                container.setBackgroundColor(getResources().getColor(R.color.white));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(num1.getText().toString().equals("") || num2.getText().toString().equals(""))
            Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show();
        else
        {
            Double N1 = Double.parseDouble(num1.getText().toString());
            Double N2 = Double.parseDouble(num2.getText().toString());
            DecimalFormat format = new DecimalFormat();
            format.setDecimalSeparatorAlwaysShown(false);

            Double kq = 0.0;
            switch (id){
                case R.id.sum:
                    kq = N1 + N2;
                    break;
                case R.id.sub:
                    kq = N1 - N2;
                    break;
                case R.id.mul:
                    kq = N1 * N2;
                    break;
                case R.id.div:
                    kq= N1 / N2;
                    break;
            }
            result.setText(String.valueOf(format.format((double)Math.round(kq * 100)/100)));
        }
        return super.onContextItemSelected(item);
    }
}