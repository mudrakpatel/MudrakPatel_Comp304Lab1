package com.example.mudrakpatel_comp304lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class RestaurantsActivity extends AppCompatActivity {

    String cuisineName;
    String[] menuItemsStrings = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurants);
        //Get a reference to the RelativeLayout
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayoutRestaurants);
        //get the intent data
        cuisineName = getIntent().getStringExtra("cuisineName");

        //Add a ToolBar to the Activity
        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbarRestaurantsActivity);
        myToolBar.setTitle(R.string.app_name);
        myToolBar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolBar);

        //Declare backButton
        Button backButton = (Button) findViewById(R.id.backBtnRestaurants);
        //Attach a click/tap event listener
        backButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onBackPressed();
            }
        });

        //Change the background image based on the cuisine
        if(cuisineName.equals("american")){
            relativeLayout.setBackgroundResource(R.drawable.americancuisinewallpaper);
        } else if(cuisineName.equals("italian")){
            relativeLayout.setBackgroundResource(R.drawable.italiancuisinewallpaper);
        } else if(cuisineName.equals("chinese")){
            relativeLayout.setBackgroundResource(R.drawable.chinesecuisinewallpaper);
        } else {
            relativeLayout.setBackgroundResource(R.drawable.indiancuisinewallpaper);
        }
    }

    //Inflate the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.restaurants_menu, menu);

        //Add items to the menu based on the cuisineName value
        //1) Initialize the strings array values based on cuisineName
        if(cuisineName.equals("american")){
            menuItemsStrings = getResources().getStringArray(R.array.americanRestaurantsArray);
        } else if(cuisineName.equals("italian")){
            menuItemsStrings = getResources().getStringArray(R.array.italianRestaurantsArray);
        } else if(cuisineName.equals("chinese")){
            menuItemsStrings = getResources().getStringArray(R.array.chineseRestaurantsArray);
        } else {
            menuItemsStrings = getResources().getStringArray(R.array.indianRestaurantsArray);
        }

        //3) Loop through the menuItemsStrings to create Item
        // and add that item to the Menu
        for(String itemString : menuItemsStrings){
            //Add menuItem to the menu
            final MenuItem menuItem = menu.add(itemString);
            //Attach a click/tap event listener to the menuItem
            menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("restaurantName", menuItem.getTitle());
                    startActivity(intent);
                    return true;
                }
            });
        }

        return true;
    }

}
