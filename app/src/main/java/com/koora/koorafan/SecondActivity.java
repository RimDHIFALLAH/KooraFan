package com.koora.koorafan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

import com.koora.koorafan.Fragments.FavoriteFrag;
import com.koora.koorafan.Fragments.ProfileFrag;
import com.koora.koorafan.Fragments.TeamsFrag;

public class SecondActivity extends AppCompatActivity {

    private Button btnFrag1, btnFrag2, btnFrag3;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
        fragmentManager = getSupportFragmentManager();
        changeFragment(new TeamsFrag(), "teams");

        btnFrag1 = findViewById(R.id.btnFrag1);
        btnFrag2 = findViewById(R.id.btnFrag2);
        btnFrag3 = findViewById(R.id.btnFrag3);

        btnFrag2.setOnClickListener(view -> {
            changeFragment(new ProfileFrag(), "profile");
        });

        btnFrag1.setOnClickListener(view -> {
            Fragment frag = new TeamsFrag();
            changeFragment( frag, "teams");
        });

        btnFrag3.setOnClickListener(view -> {
            Fragment frag = new FavoriteFrag();
            changeFragment( frag, "favorite");
        });

    }
    private void changeFragment(Fragment fragment, String tag){
        if (tag.isEmpty()){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(tag)
                    .commit();
        }

    }
}