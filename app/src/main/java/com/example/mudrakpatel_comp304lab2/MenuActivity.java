package com.example.mudrakpatel_comp304lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Declare the Button backBtnMenu
        Button backBtnMenu = (Button) findViewById(R.id.backBtnMenu);
        //Attach a click/tap event listener
        backBtnMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onBackPressed();
            }
        });
    }
}
