package com.example.searchcustomrecycler;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
String[] name={"Chicken Snacks","Fries With Hamburger","Fritters","Fruit Custard","PineApple","Combo Dish Pack","Pie","Pluffy Chapati","Salad"};
int[] img={R.drawable.chicken_snacks,R.drawable.fries_with_hamburger,R.drawable.fritters,R.drawable.fruit_custard,R.drawable.image_search_1563197555359,
        R.drawable.image_search_1563197569590,R.drawable.pie,R.drawable.pluffy_chapati,R.drawable.salad};
Toolbar toolbar;RecyclerView.LayoutManager layoutManager;ArrayList<Dish> arrayList;
RecyclerView recyclerView;RecyclerAdapter adapter;@Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rec);toolbar=(Toolbar)findViewById(R.id.tool);setSupportActionBar(toolbar);
        arrayList=new ArrayList<>();layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        int count=0;
        for(String Name : name){
            arrayList.add(new Dish(Name,img[count]));count++; }
        adapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter); }
        @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem=menu.findItem(R.id.see);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true; }
        @Override public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override public boolean onQueryTextChange(String newText) { newText=newText.toLowerCase();
        ArrayList<Dish> newList=new ArrayList<>();
        for (Dish dish : arrayList){ String name=dish.getName().toLowerCase();
            if (name.contains(newText))
                newList.add(dish); }adapter.setFilter(newList);
        return true; }}