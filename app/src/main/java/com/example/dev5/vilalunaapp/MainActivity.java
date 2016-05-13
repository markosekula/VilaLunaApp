package com.example.dev5.vilalunaapp;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    NavigationView navigationView;
    GridView gridView;
   // Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<ItemObject> rowListItem = getAllItemList();
        ImageAdapter adapter =  new ImageAdapter(this, rowListItem);
        gridView.setAdapter(adapter);


        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setUpNav(MainActivity.this, navigationView, mDrawerLayout);
       // navigationView.getMenu().getItem(0).setChecked(true);

        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList();
        allItems.add(new ItemObject(getString(R.string.activity_apartments), R.drawable.apartments));
        allItems.add(new ItemObject(getString(R.string.activity_zlatibor), R.drawable.zlatibor));
        allItems.add(new ItemObject(getString(R.string.activity_gallery), R.drawable.gallery));
        allItems.add(new ItemObject(getString(R.string.activity_contact), R.drawable.contact));

        return allItems;
    }



}
