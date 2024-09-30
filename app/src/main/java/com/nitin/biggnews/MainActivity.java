package com.nitin.biggnews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    String api="0f274ad5028d47e0af35ab8213f29238";
    Toolbar toolbar;
    TabLayout tabLayout;
    TabItem home,health,science,buisness,sports,entertainment;
    ViewPager viewPager;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=findViewById(R.id.tab);
        home=findViewById(R.id.home);
        health=findViewById(R.id.health);
        science=findViewById(R.id.science);
        sports=findViewById(R.id.sports);
        buisness=findViewById(R.id.buisness);
        viewPager=findViewById(R.id.viewpager);
        entertainment=findViewById(R.id.entertainment);

        pagerAdapter adapter1=new pagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(adapter1);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0|| tab.getPosition()==1|| tab.getPosition()==2||tab.getPosition()==3|| tab.getPosition()==4 || tab.getPosition()==5){
                    adapter1.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}