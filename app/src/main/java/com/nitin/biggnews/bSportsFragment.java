package com.nitin.biggnews;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class bSportsFragment extends Fragment {
    String api="0f274ad5028d47e0af35ab8213f29238";
    private RecyclerView sportsRecyclerView;
    itemAdapter adapter2;
   private String country="us";
   private String category="sports";
    ArrayList<ModelClass> arrayList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_b_sports, container, false);
        sportsRecyclerView=v.findViewById(R.id.sportsRecyclerView);
        String apiKey="0f274ad5028d47e0af35ab8213f29238";
        arrayList=new ArrayList<>();
        sportsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter2=new itemAdapter(getContext(),arrayList);
        sportsRecyclerView.setAdapter(adapter2);

        findNews();

        return v;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,80,api).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    arrayList.addAll(response.body().getArticles());
                    adapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}