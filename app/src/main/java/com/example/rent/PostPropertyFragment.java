package com.example.rent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


/**
 * A simple {@link Fragment} subclass.
 */
public class PostPropertyFragment extends Fragment {


    public PostPropertyFragment() {
        // Required empty public constructor
    }

    Button btn_post ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_post_property, container, false);
        btn_post = v.findViewById(R.id.post);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity() , Home.class );
                Toast.makeText(getContext() , " Property posted Successfully" , Toast.LENGTH_SHORT).show();

                startActivity(i);
            }
        });
    return v;
    }

}
