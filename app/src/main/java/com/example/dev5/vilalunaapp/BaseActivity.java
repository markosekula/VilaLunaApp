package com.example.dev5.vilalunaapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    Intent intent;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.content_main);

    }

    public void setUpNav(final Context context, NavigationView navigationView, final DrawerLayout mDrawerLayout) {

        this.drawerLayout=mDrawerLayout;
        this.navigationView= navigationView;

        mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout,toolbar ,
                R.string.drawer_open, R.string.drawer_close
        );
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()){
                    case R.id.nav_home:
                        if (!context.getClass().equals(MainActivity.class)) {
                            intent = new Intent(context, MainActivity.class);
                            context.startActivity(intent);
                        }
                        break;

                    case R.id.nav_apartments:
                        intent = new Intent(context, Apartments.class);
                        context.startActivity(intent);
                        break;

                    case R.id.nav_zlatibor:
                        intent = new Intent(context, Zlatibor.class);
                        context.startActivity(intent);
                        break;

                    case R.id.nav_gallery:
                        intent = new Intent(context, Gallery.class);
                    context.startActivity(intent);
                        break;

                    case R.id.nav_contact:
                        intent = new Intent(context, Contact.class);
                        context.startActivity(intent);
                        break;

                }

                return true;
            }
        });

    }
}
