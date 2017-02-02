package com.example.alejandro.algorithms.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alejandro.algorithms.Adapters.BasicAdapter;
import com.example.alejandro.algorithms.Lists.BasicList;
import com.example.alejandro.algorithms.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;


public class BasicFragment extends Fragment {

    public static final String ARG_PAGE = "ARG:PAGE";

    private int mPage;

    BasicAdapter mAdapter;
    RecyclerView recyclerView;
    List<BasicList> data = new ArrayList<>();


    int num_items = 3;
    String[] title = {"Burbuja(Bubble)", "Selección(Select)", "Inserción(Insert)"};
    String[] description = {"Uso no Recomendable", "No depende de la entrada, siempre tarda lo mismo","Cuando el número de cambios es bajo"};
    //int[] logo = {R.drawable.celupal, R.drawable.octanorm, R.drawable.merca, R.drawable.grupomundo, R.drawable.grupomacro, R.drawable.peope, R.drawable.oki, R.drawable.fyvar, R.drawable.colorescreativos, R.drawable.logotnp, R.drawable.logosideco, R.drawable.logogcuatro, R.drawable.logocdo, R.drawable.amppro, R.drawable.backstage, R.drawable.anahuac};


    public static BasicFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        BasicFragment fragment = new BasicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_basic, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView_basic);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for (int i = 0; i < num_items; i++) {
            BasicList item = new BasicList();
            item.setTitle(title[i]);
            item.setDescription(description[i]);
            data.add(item);
        }
        poblarRecicyer(data);
    }


    private void poblarRecicyer(List<BasicList> list) {
        recyclerView.setItemAnimator(new FadeInAnimator());
        mAdapter = new BasicAdapter(getActivity(), list);
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mAdapter);
        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
        mAdapter.SetOnItemClickListener(new BasicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

}
