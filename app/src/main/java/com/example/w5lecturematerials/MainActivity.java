package com.example.w5lecturematerials;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
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
}