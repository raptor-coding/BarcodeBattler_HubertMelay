package com.cecile_melay.barcodebattler_hubertmelay.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cecile_melay.barcodebattler_hubertmelay.utils.Util;

/**
 * Created by Utilisateur on 23/10/2017.
 */

public abstract class MyFragment extends Fragment {
    protected ViewGroup contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Util.setCurrentFragment(this);
        this.contentView = (ViewGroup) inflater.inflate(getLayoutId(), null, false);
        //Util.hideSoftKeyboard();
        init();
        return this.contentView;
    }

    protected void init() {
//        Util.getMainActivity().setNavTitle(getTitle());
    }

    protected abstract int getLayoutId();

    protected abstract String getTitle();

    @Override
    public void onStop() {
        //Util.getMainActivity().removeFragment();
        super.onStop();
    }

    public void finish(boolean restoreMap) {
        Util.getMainActivity().closeCurrentFragment(this, restoreMap);
    }

    @Nullable
    @Override
    public View getView() {
        return contentView;
    }
}