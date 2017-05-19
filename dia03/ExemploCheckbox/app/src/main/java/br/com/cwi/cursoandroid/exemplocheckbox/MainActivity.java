package br.com.cwi.cursoandroid.exemplocheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEstouComSorte;
    private CheckBox chkViciadoBacon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        // LOAD
        this.chkViciadoBacon = (CheckBox)findViewById(R.id.chkViciadoBacon);
        this.btnEstouComSorte = (Button)findViewById(R.id.btnEstouComSorte);
        // EVENTS
        this.chkViciadoBacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast toast = Toast.makeText(getApplicationContext(), "Mexeu " + isChecked, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 50, 50);
                toast.show();
            }
        });
        this.btnEstouComSorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = chkViciadoBacon.isChecked() ? "Muito bacon na vida" : "Nem tanta sorte assim...";
                // https://developer.android.com/guide/topics/ui/notifiers/toasts.html
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
            }
        });
    }
}
