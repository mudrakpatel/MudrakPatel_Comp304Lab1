package com.example.mudrakpatel_comp304lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate the Button enterBtn
        Button enterBtn = (Button) findViewById(R.id.enterBtn);
        //attach a click/tap event handler to enterBtn
        enterBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), CuisineActivity.class));
            }
        });
    }
}
