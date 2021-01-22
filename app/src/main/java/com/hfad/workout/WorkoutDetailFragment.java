package com.hfad.workout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {
    //Идентификатор комплекса упражнений, выбранного пользователем. Позднее, при выводе
    //подробной информации, он будет использован для заполнения представлений фрагмента.
    private long workoutId;

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.stopwatch_container, stopwatchFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.commit();

        } else {
            workoutId = savedInstanceState.getLong("workoutId");
        }

    }

    @Override
    public void onStart() {
        //Метод getView() получает корневой объект View фрагмента. Далее полученный
        //объект используется для получения ссылок на надписи, предназначенные для названия и описания комплекса упражнений.
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());

            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    //Метод для присваивания идентификатора. Метод используется
    //активностью для передачи значения идентификатора фрагменту.
    public void setWorkoutId(long id) {
        this.workoutId = id;
    }

    //Метод onCreateView() вызывается тогда, когда Android потребуется макет фрагмента.
    @Override                //используется для заполнения макета фрагмента
    public View onCreateView(LayoutInflater inflater, ViewGroup container,//объект ViewGroup из макета активности, содержащий фрагмент.
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
        //Сообщает Android, какой макет используется фрагментом (в данном
        //случае fragment_workout_detail).
    }
}