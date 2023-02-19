package com.example.finalproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.finalproject.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private List<item> itemList;
//TODO FINISH MAIN PAGE  AND PROFILE PAGE AND ADD ITEMS TO LIST
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       //TODO how to make this main activity replaceFragment(new homefragment);
        binding.BottomNavigationView.setOnItemSelectedListener(item ->{

           switch (item.getItemId()){
               case R.id.Home:
                 // TODO how to make this go to main activity  replaceFragment(new);
                   break;
               case R.id.Profile:
                   replaceFragment(new ProfileFragment());
                   break;
               case R.id.Settings:
                   replaceFragment(new SettingsFragment());
                   break;


           }

            return true;
        } );
        searchView.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        itemList = new ArrayList<>();
        // add data to item list
        itemList.add(new Item(itemNamez))
        setContentView(R.layout.activity_main);
        private void initMenu() {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);

        }

    }

    private void filterList(String text) {
        List<Item> filteredList= new ArrayList<>();
        for (Item item; itemList){

        }

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frame_layout_main,fragment);
        fragmentTransaction.commit();
    }
}