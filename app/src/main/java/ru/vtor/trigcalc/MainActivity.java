package ru.vtor.trigcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText vvod; //поле для ввода числа
    TextView vyvod; //поля для вывода результат
    CheckBox check1;
    CheckBox check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this, "Вторушин Евгений Игоревич", Toast.LENGTH_LONG);
        toast.show();

        vvod = findViewById(R.id.Vvod);
        vyvod = findViewById(R.id.Vyvod);
        check1 = findViewById(R.id.Radian);
        check2 = findViewById(R.id.Gradus);
    }

    public void onCheckClick (View v) {
        switch (v.getId()) {
            case R.id.Rad:
                check1.setChecked(true);
                check2.setChecked(false);
                break;
            case R.id.Grad:
                check1.setChecked(false);
                check2.setChecked(true);
                break;
        }
    }

    float res, num, num2;

    public void onButtonClick (View v) {
        num = Float.parseFloat(vvod.getText().toString());
        switch (v.getId()) {
            case R.id.Sin:
                if (check1.isChecked())
                {
                    res = (float) Math.sin(num);
                    break;
                }
                else if (check2.isChecked())
                {
                    num2 = ((float) Math.PI / (float) 180) * num;
                    res = (float) Math.sin(num2);
                    break;
                }
            case R.id.Cos:
                if (check1.isChecked())
                {
                    res = (float) Math.cos(num);
                    break;
                }
                else if (check2.isChecked())
                {
                    num2 = ((float) Math.PI / (float) 180) * num;
                    res = (float) Math.cos(num2);
                    break;
                }
            case R.id.Tg:
                if (check1.isChecked())
                {
                    res = (float) Math.tan(num);
                    break;
                }
                else if (check2.isChecked())
                {
                    num2 = ((float) Math.PI / (float) 180) * num;
                    res = (float) Math.tan(num2);
                    break;
                }
            case R.id.Ctg:
                if (check1.isChecked())
                {
                    res = (float) 1.0 / ((float) Math.tan(num));
                    break;
                }
                else if (check2.isChecked())
                {
                    num2 = ((float) Math.PI / (float) 180) * num;
                    res = (float) 1.0 / ((float) Math.tan(num2));
                    break;
                }
            case R.id.Log:
                if (check1.isChecked())
                {
                    res = (float) Math.log(num);
                    break;
                }
                else if (check2.isChecked())
                {
                    res = (float) Math.log(num);
                    break;
                }
            case R.id.Lg:
                if (check1.isChecked())
                {
                    res = (float) Math.log10(num);
                    break;
                }
                else if (check2.isChecked())
                {
                    res = (float) Math.log10(num);
                    break;
                }
        }
        vyvod.setText(Float.toString(res));
    }

    public void onStuticClick (View v) {
        switch (v.getId()) {
            case R.id.P:
                vvod.setText(Double.toString(Math.PI));
                vyvod.setText("");
                break;
            case R.id.E:
                vvod.setText(Double.toString(Math.E));
                vyvod.setText("");
                break;
        }
    }

    public void onSmenaClick (View v) {
        float PM = Float.parseFloat(vvod.getText().toString());
        if (PM > 0)
            vvod.setText("-" + Float.toString(PM));
        else
            vvod.setText(Float.toString(Math.abs(PM)));
    }

    public void onClearClick (View v) {
        vvod.setText("");
        vyvod.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    public void onExitMenuClick (MenuItem item) {
        finish ();
    }

}
