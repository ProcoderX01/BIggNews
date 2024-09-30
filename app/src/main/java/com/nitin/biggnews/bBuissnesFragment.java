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


public class bBuissnesFragment extends Fragment {
    String api="0f274ad5028d47e0af35ab8213f29238";
    private RecyclerView buisnessRecyclerView;
    itemAdapter adapter2;
    private String country="us";
   private String category="business";
    ArrayList<ModelClass> arrayList;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_b_buissnes, container, false);
        buisnessRecyclerView=v.findViewById(R.id.buisnessRecyclerView);
        arrayList=new ArrayList<>();
        buisnessRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter2=new itemAdapter(getContext(),arrayList);
        buisnessRecyclerView.setAdapter(adapter2);

        findNews();

    return v;

}

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,80,api).enqueue(new Callback<MainNews>() {
            @SuppressLint("NotifyDataSetChanged")
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

            }
        });
    }
    }
