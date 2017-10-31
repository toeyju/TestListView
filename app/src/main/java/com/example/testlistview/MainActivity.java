package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Animal> mData;
    //private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        AnimalData animalData = AnimalData.getInstance();
        animalData.animalList = new ArrayList<>();

        mData = new ArrayList<>();
        /*mData.add("Cat");
        mData.add("Dog");
        mData.add("Lion");
        mData.add("Hippo");
        mData.add("Panda");
        mData.add("Snake");
        mData.add("Giraffe");*/

        //Animal animal = new Animal("Cat",R.drawable.animals_cat);
        //mData.add(animal);
        mData.add(new Animal("Cat",R.drawable.cat));
        mData.add(new Animal("Dog",R.drawable.dog));
        mData.add(new Animal("Dolphin",R.drawable.dolphin));
        mData.add(new Animal("Koala",R.drawable.koala));
        mData.add(new Animal("Owl",R.drawable.owl));
        mData.add(new Animal("Rabbit",R.drawable.rabbit));
        mData.add(new Animal("Penguin",R.drawable.penguin));
        mData.add(new Animal("Tiger",R.drawable.tiger));
        mData.add(new Animal("Pig",R.drawable.pig));
        mData.add(new Animal("Lion",R.drawable.lion));

        AnimalListAdapter adapter = new AnimalListAdapter(this,  R.layout.item,mData);


        mListView.setAdapter(adapter); //ยัดข้อมูลลงในListView

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = mData.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                intent.putExtra("name", animal.name);
                intent.putExtra("picture", animal.picture);
                startActivity(intent);
            }
        });
    }
}
