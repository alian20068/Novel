package com.newjoin.novel.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newjoin.novel.R;

/**
 * Created by NewJoin on 2018/12/31.
 */

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment3,container,false);
    }
}
