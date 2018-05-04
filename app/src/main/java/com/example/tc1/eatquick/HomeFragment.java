package com.example.tc1.eatquick;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by TC1 on 16/03/2018.
 */
public class HomeFragment extends Fragment {
    Spinner spinnerState, spinnerMeal;
    ArrayAdapter<String> arrayAdapter1, getArrayAdapter2;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Home");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        spinnerState = (Spinner) view.findViewById(R.id.sp_state);
        Resources res1 = getResources();
        String[] stateItem = res1.getStringArray(R.array.state);
        arrayAdapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, stateItem);
        spinnerState.setAdapter(arrayAdapter1);

        spinnerMeal = (Spinner) view.findViewById(R.id.sp_meal);
        Resources res2 = getResources();
        String[] mealItem = res2.getStringArray(R.array.meals);
        getArrayAdapter2 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mealItem);
        spinnerMeal.setAdapter(getArrayAdapter2);

        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<>();
        String country;
        for (Locale loc : locale) {
            country = loc.getDisplayCountry();
            if (country.length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);

        Spinner citizenship = (Spinner) view.findViewById(R.id.sp_country);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countries);
        citizenship.setAdapter(adapter);

        return view;
    }
}