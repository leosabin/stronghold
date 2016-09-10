package com.team980.thunderscout.match;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.team980.thunderscout.R;
import com.team980.thunderscout.data.ScoutData;
import com.team980.thunderscout.data.enumeration.Defense;

public class TeleopFragment extends Fragment {

    private ScoutData scoutData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teleop, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NestedScrollView teleopScroll = (NestedScrollView) view.findViewById(R.id.teleop_scrollView);
        teleopScroll.setOnScrollChangeListener((ScoutActivity) getActivity());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ScoutActivity scoutActivity = (ScoutActivity) getActivity();
        scoutData = scoutActivity.getData();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Called when view state changes for this fragment
     *
     * @param isVisibleToUser
     */
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (this.isVisible() && !isVisibleToUser && scoutData != null) { //Leaving

            AppCompatEditText teamNumber = (AppCompatEditText) getView().findViewById(R.id.teleop_editTextTeamNumber);
            scoutData.setTeamNumber(teamNumber.getText().toString());
        }

        if (this.isVisible() && isVisibleToUser && scoutData != null) { //Returning

            AppCompatEditText teamNumber = (AppCompatEditText) getView().findViewById(R.id.teleop_editTextTeamNumber);
            teamNumber.setText(scoutData.getTeamNumber(), TextView.BufferType.NORMAL);
        }
    }
}