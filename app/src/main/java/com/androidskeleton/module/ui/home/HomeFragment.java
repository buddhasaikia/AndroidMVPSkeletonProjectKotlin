package com.androidskeleton.module.ui.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidskeleton.R;
import com.androidskeleton.di.scope.PerActivity;
import com.androidskeleton.module.base.DaggerBaseFragment;

import javax.inject.Inject;

@PerActivity
public class HomeFragment extends DaggerBaseFragment implements HomeContract.View {

    private OnFragmentInteractionListener mListener;
    @Inject
    HomeContract.Presenter presenter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void greetings(String message) {
        TextView lblGreetings = view.findViewById(R.id.lbl_greetings);
        lblGreetings.setText(message);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
        presenter.sayHello();
    }

    @Override
    public void onPause() {
        presenter.dropView();
        super.onPause();
    }
}
