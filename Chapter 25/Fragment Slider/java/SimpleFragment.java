package com.gamecodeschool.fragmentslider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SimpleFragment extends Fragment {

    // Holds the fragment id passed in when created
    public static final String MESSAGE = "";

    // Our newInstance method which we call to make a new Fragment
    public static SimpleFragment newInstance(String message)
    {
        // Create the fragment
        SimpleFragment fragment = new SimpleFragment();

        // Create a bundle for our message/id
        Bundle bundle = new Bundle(1);
        // Load up the Bundle
        bundle.putString(MESSAGE, message);
        // Call setArguments ready for when onCreate is called
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Get the id from the Bundle
        String message = getArguments().getString(MESSAGE);

        // Inflate the view as normal
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        // Get a reference to textView
        TextView messageTextView = (TextView)view.findViewById(R.id.textView);

        // Display the id in the TextView
        messageTextView.setText(message);

        // We could also handle any UI
        // of any complexity in the usual way
        // And we will over the next two chapters
        // ..
        // ..

        return view;
    }

}
