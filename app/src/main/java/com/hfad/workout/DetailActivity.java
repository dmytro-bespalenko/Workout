package com.hfad.workout;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //получает ссылку на WorkoutDetailFragment, запрашивая у диспетчера фрагментов фрагмент с идентификатором detail_frag.
        WorkoutDetailFragment fragment = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        assert fragment != null;
        fragment.setWorkoutId(workoutId);
    }
}