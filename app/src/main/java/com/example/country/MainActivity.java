package com.example.country;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Country> countryArrayLists = new ArrayList<>();
    ListView simpleList;
    String[] countryList = {"Russia", "China",
            "Germany", "India", "Italia", "France",
            "Canada", "USA", "Vietnam", "Great Britain",
            "Portugal", "Spain"};

    int[] flags = {R.drawable.russia, R.drawable.china,
            R.drawable.germany, R.drawable.india,
            R.drawable.italia, R.drawable.france,
            R.drawable.canada, R.drawable.usa,
            R.drawable.vietnam, R.drawable.great_britain,
            R.drawable.portugal, R.drawable.spain
    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (countryArrayLists.isEmpty()) {
            for (int i = 0; i < countryList.length; i++) {
                countryArrayLists.add(new Country(countryList[i], flags[i]));
            }
        }

        simpleList = findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryArrayLists);
        simpleList.setAdapter(customAdapter);
    }

    private static class CustomAdapter extends BaseAdapter {
        Context context;
        List<Country> countryArrayLists;
        LayoutInflater inflater;


        public CustomAdapter(Context applicationContext, List<Country> countryArrayLists) {
            this.context = applicationContext;
            this.countryArrayLists = countryArrayLists;
            inflater = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return countryArrayLists.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = inflater.inflate(R.layout.activity_item, null);

            TextView country = (TextView) view.findViewById(R.id.textView);
            ImageView flag = (ImageView) view.findViewById(R.id.icon);

            country.setText(countryArrayLists.get(position).country);
            flag.setImageResource(countryArrayLists.get(position).flagId);

            return view;
        }
    }
}