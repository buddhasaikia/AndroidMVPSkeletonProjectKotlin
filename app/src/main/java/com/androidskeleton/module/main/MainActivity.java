package com.androidskeleton.module.main;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.androidskeleton.R;
import com.androidskeleton.module.base.DaggerBaseActivity;
import com.androidskeleton.module.ui.home.HomeFragment;
import com.androidskeleton.util.ActivityUtils;

public class MainActivity extends DaggerBaseActivity
        implements HomeFragment.OnFragmentInteractionListener {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HomeFragment mainFragment = HomeFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.container);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
