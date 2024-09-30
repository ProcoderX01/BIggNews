package com.nitin.biggnews;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class bHomeFragment extends Fragment {
    String api="0f274ad5028d47e0af35ab8213f29238";
    private RecyclerView homeRecyclerView;
    itemAdapter adapter2;
    private String country="us";
    ArrayList<ModelClass> arrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_b_home, container, false);
        homeRecyclerView=v.findViewById(R.id.homeRecyclerView);
        String apiKey="0f274ad5028d47e0af35ab8213f29238";
        arrayList=new ArrayList<>();
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter2=new itemAdapter(getContext(),arrayList);
        homeRecyclerView.setAdapter(adapter2);

        findNews();

        return v;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,80,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {

                if(response.isSuccessful()){
                    Log.d("Res",response.toString());
                    arrayList.addAll(response.body().getArticles());
                    adapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {
                  t.printStackTrace();
                  Log.e("ResError",t.toString());
            }
        });
    }
}