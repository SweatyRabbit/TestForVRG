package com.example.testforvrgsoft.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testforvrgsoft.R;
import com.example.testforvrgsoft.models.TopResponse;
import com.example.testforvrgsoft.network.ApiFactory;
import com.example.testforvrgsoft.ui.adapter.PubAdapter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ListPublicationsFragment extends Fragment  {
    private PubAdapter pubAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_publications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        showPubs();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @SuppressLint("CheckResult")
    public void showPubs() {

        Observable<TopResponse> observable = ApiFactory.getApi().getPub();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    pubAdapter = new PubAdapter(response.getData().getChildren(), url -> {
                        Bundle data = new Bundle();
                        data.putString(PhotoFragment.URL, url);
                        Navigation.findNavController(getView()).navigate(R.id.photoFragment, data);
                    });
                    recyclerView.setAdapter(pubAdapter);
                }, Throwable::printStackTrace);
    }


}
