package com.hfad.workout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        if (savedInstanceState == null) {
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
                                                                //Добавляет транзакцию фрагмента
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //Экземпляр StopwatchFragment включается в макет TempActivity.
            ft.add(R.id.stopwatch_container, stopwatchFragment);
            //Транзакция включается в стек возврата
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //Закрепление транзакции.
            ft.commit();
        }
    }


}