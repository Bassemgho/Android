package com.example.login.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.login.R;
import com.example.login.databinding.ActivityHomeBinding;
import com.example.login.fragments.HomeFragment;
import com.example.login.fragments.InfoFragment;
import com.example.login.fragments.ProfileFragment;
import com.example.login.fragments.ScanFragment;
import com.example.login.fragments.ShopFragment;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;
    InfoFragment infoFragment;
    ScanFragment scanFragment;
    ProfileFragment profilefragment;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(HomeActivity.this,R.layout.activity_home);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        SharedPreferences preferences = getSharedPreferences("com.example.login", Context.MODE_PRIVATE);
        preferences.edit().putString("token",getIntent().getStringExtra("token")).apply();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,binding.drawerlayout,R.string.nav_open,R.string.nav_close);
        binding.drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();
        binding.viewnavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        fragmentTransaction.replace(R.id.container_fragment,new HomeFragment()).commit();
                        binding.drawerlayout.closeDrawers();
                        return true;
                    case R.id.Profile:
                        fragmentTransaction.replace(R.id.container_fragment,new ProfileFragment()).commit();
                        binding.drawerlayout.closeDrawers();
                        return true;
                    case R.id.shop:
                        fragmentTransaction.replace(R.id.container_fragment,new ShopFragment()).commit();
                        binding.drawerlayout.closeDrawers();
                        return true;
                    case R.id.info:
                        fragmentTransaction.replace(R.id.container_fragment,new InfoFragment()).commit();
                        binding.drawerlayout.closeDrawers();
                        return true;

                    case R.id.logout:
                        logout();
                        binding.drawerlayout.closeDrawers();
                        return true;
                    default:
                        fragmentTransaction.replace(R.id.container_fragment,new HomeFragment()).commit();
                        binding.drawerlayout.closeDrawers();
                        return true;

                }

            }
        });


    }






//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.drawer,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()){
            case R.id.home:
                fragmentTransaction.replace(R.id.container_fragment,new HomeFragment()).commit();
                binding.drawerlayout.closeDrawers();
                break;
            case R.id.info:
                fragmentTransaction.replace(R.id.container_fragment,new InfoFragment()).commit();
                binding.drawerlayout.closeDrawers();
                break;

            case R.id.logout:
                logout();
                binding.drawerlayout.closeDrawers();
            default:
                fragmentTransaction.replace(R.id.container_fragment,new HomeFragment()).commit();
                binding.drawerlayout.closeDrawers();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        Toast.makeText(getApplicationContext(),"you are going to logout",Toast.LENGTH_SHORT).show();
    }
}