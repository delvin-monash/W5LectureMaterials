package com.example.w5lecturematerials;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new MyWeek5NavHandler());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        /*Check if itemId is matching that of camera or search 
        * depending on which id has been triggered, carry out action*/
        
        if(itemId == R.id.options_search) {
            Toast.makeText(this, "Search triggered", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.options_camera) {
            Toast.makeText(this, "Camera triggered", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something else", Toast.LENGTH_SHORT).show();
        }
        
        return super.onOptionsItemSelected(item);
    }

    public void makeSnackbar(String msg) {
        Snackbar
                .make(drawerLayout, msg, Snackbar.LENGTH_LONG)
                .show();
    }

    class MyWeek5NavHandler implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.options_camera) {
                makeSnackbar("Hello selfie!");
            } else if (itemId == R.id.options_search) {
                makeSnackbar("Search away");
            } else if (itemId == R.id.options_contact) {
                makeSnackbar("Oh you have friends!");
            }
            drawerLayout.closeDrawers();
            return true;
        }
    }
}