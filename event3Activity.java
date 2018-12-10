package com.example.qonitpptb.eventku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class event3Activity extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event3);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "Pendidikan 1",
                        "Sasana Budaya Ganesha-12-01-2019",
                        4.3,
                        60000,
                        R.drawable.p1));

        productList.add(
                new Product(
                        1,
                        "Pendidikan 2",
                        "Jakarta Convention Hall-04-02-2019",
                        4.3,
                        100000,
                        R.drawable.p2));

        productList.add(
                new Product(
                        1,
                        "Pendidikan 3",
                        "Hotel Trans Bandung - 13-03-2019",
                        4.3,
                        100000,
                        R.drawable.p3));

        productList.add(
                new Product(
                        1,
                        "Pendidikan 4",
                        "Bandung Indah Plaza-0-04-2019",
                        4.3,
                        60000,
                        R.drawable.p4));

        productList.add(
                new Product(
                        1,
                        "Pendidikan 5",
                        "Paris Van Java Bandung-02-05-2019",
                        4.3,
                        60000,
                        R.drawable.p5));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

        finish();
        startActivity(new Intent(this, Main1Activity.class));

    }
}