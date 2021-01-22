package com.hfad.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void itemClicked(long id) {

        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            WorkoutDetailFragment fragment = new WorkoutDetailFragment();
            //Начало транзакции фрагмента
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            fragment.setWorkoutId(id);
            //Замена фрагмента
            transaction.replace(R.id.fragment_container, fragment);
            //Новый и старый фрагменты должны сопровождаться анимациями проявления и растворения.
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //Транзакция включается в стек возврата.
            transaction.addToBackStack(null);
            //Закрепление транзакции.
            transaction.commit();

        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}