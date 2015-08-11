package com.firstlight.firstlight_v3;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainContentFragment extends android.support.v4.app.Fragment {


    private OnFragmentInteractionListener mListener;


    //Variables declared for adapter and Recycler View
    private MainContentAdapter adapter;
    private RecyclerView recyclerView;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment MainContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainContentFragment newInstance() {
        MainContentFragment fragment = new MainContentFragment();
        return fragment;
    }

    public MainContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_main_content, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.my_recycler_view);
        adapter = new MainContentAdapter(getActivity(),getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;

    }

    public static List<SubscribeItem> getData(){
        List<SubscribeItem>  data = new ArrayList<>();
        int[] icons = {R.drawable.ic_menu_check, R.drawable.ic_menu_check, R.drawable.ic_menu_check, R.drawable.ic_menu_check};
        String[] titles = {"Sushant", "Rohit", "Nivedan", "Jai"};
        for(int i=0; i<titles.length && i<icons.length; i++){
            SubscribeItem current = new SubscribeItem();
            current.title = titles[i];
            current.iconid = icons[i];
            data.add(current);
    }
        return data;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
