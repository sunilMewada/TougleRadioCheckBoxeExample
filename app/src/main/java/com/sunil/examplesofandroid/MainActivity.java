    package com.sunil.examplesofandroid;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button btn;
   private ToggleButton togglebtn1,togglebtn2;
    String a,b;
    private CheckBox chkbutton1,chkbutton2,chkbutton3;
    Button btn2;
    private RadioGroup rdgroup;
    private RadioButton rdbutton;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button)findViewById(R.id.button);
        togglebtn1=(ToggleButton)findViewById(R.id.toggle);
        togglebtn2=(ToggleButton)findViewById(R.id.toggle2);
        addListenerOnButton();
        rdgroup= (RadioGroup)findViewById(R.id.radioGroup);
        button=(Button)findViewById(R.id.button3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectId=rdgroup.getCheckedRadioButtonId();
                rdbutton=(RadioButton)findViewById(selectId);
                Toast.makeText(MainActivity.this,rdbutton.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("ToggleButton1 : ").append(togglebtn1.getText());
                result.append("\nToggleButton2 : ").append(togglebtn2.getText());
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
    public void addListenerOnButton(){
        chkbutton1=(CheckBox)findViewById(R.id.check1);
        chkbutton2=(CheckBox)findViewById(R.id.check2);
        chkbutton3=(CheckBox)findViewById(R.id.check3);
        btn2=(Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("IPhone check : ").append(chkbutton1.isChecked());
                result.append("\nAndroid check : ").append(chkbutton2.isChecked());
                result.append("\nwindows check : ").append(chkbutton3.isChecked());
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_SHORT).show();


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to close this application ? ")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                finish();

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Alert DialogExample");
                alertDialog.show();
                setContentView(R.layout.activity_main);

            }
        });
    }

}