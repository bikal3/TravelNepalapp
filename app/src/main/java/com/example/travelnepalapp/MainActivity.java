package com.example.travelnepalapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.travelnepalapp.Model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
Toolbar toolbar;
DrawerLayout drawerLayout;
NavigationView navigationView;
MenuItem menuItem;
    private String data = "";

    private RecyclerView recyclerAdapter;
    private List<DashboardModel> dashboardModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);


        toolbar=findViewById(R.id.toolbar);
        menuItem=findViewById(R.id.it_setting);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(this);
        recyclerAdapter = findViewById(R.id.rv_recyclerview);
        recyclerAdapter.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerAdapter.setAdapter(new DashboardRecyclerView(getApplicationContext(), dashboardModels));


        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id= menuItem.getItemId();
        switch (id){
            case R.id.it_setting:
                Intent intent = new Intent(MainActivity.this, LoginSignup.class);
                startActivity(intent);

                break;
            case R.id.it_setting1:
                Intent intent1 = new Intent(MainActivity.this,LoginSignup.class);
                startActivity(intent1);

        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.navigation_menu,menu);

        return true;
    }
}
