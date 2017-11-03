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
    //private ArrayList<Animal> mData;
    //private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        final AnimalData animalData = AnimalData.getInstance();
        animalData.animalList = new ArrayList<>();

        //mData = new ArrayList<>();
        /*mData.add("Cat");
        mData.add("Dog");
        mData.add("Lion");
        mData.add("Hippo");
        mData.add("Panda");
        mData.add("Snake");
        mData.add("Giraffe");*/

        //Animal animal = new Animal("Cat",R.drawable.animals_cat);
        //mData.add(animal);
        animalData.animalList.add(new Animal("แมว (Cat)",R.drawable.cat,R.string.details_cat));
        animalData.animalList.add(new Animal("หมา (Dog)",R.drawable.dog,R.string.details_dog));
        animalData.animalList.add(new Animal("โลมา (Dolphin)",R.drawable.dolphin,R.string.details_dolphin));
        animalData.animalList.add(new Animal("โคอาลา (Koala)",R.drawable.koala,R.string.details_koala));
        animalData.animalList.add(new Animal("นกฮูก (Owl)",R.drawable.owl,R.string.details_owl));
        animalData.animalList.add(new Animal("กระต่าย (Rabbit)",R.drawable.rabbit,R.string.details_rabbit));
        animalData.animalList.add(new Animal("เพนกวิน (Penguin)",R.drawable.penguin,R.string.details_penguin));
        animalData.animalList.add(new Animal("เสือ (Tiger)",R.drawable.tiger,R.string.details_tiger));
        animalData.animalList.add(new Animal("หมู (Pig)",R.drawable.pig,R.string.details_pig));
        animalData.animalList.add(new Animal("สิงโต (Lion)",R.drawable.lion,R.string.details_lion));

        AnimalListAdapter adapter = new AnimalListAdapter(this,  R.layout.item, animalData.animalList);


        mListView.setAdapter(adapter); //ยัดข้อมูลลงในListView

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = animalData.animalList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                //intent.putExtra("name", animal.name);
                //intent.putExtra("picture", animal.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });
    }
}
