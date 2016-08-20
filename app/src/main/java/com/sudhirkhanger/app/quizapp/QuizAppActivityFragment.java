package com.sudhirkhanger.app.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizAppActivityFragment extends Fragment {

    private RadioGroup mRadioGroupQ1;
    private boolean isRadioGroupQ1Scored;
    private RadioGroup mRadioGroupQ2;
    private boolean isRadioGroupQ2Scored;
    private RadioGroup mRadioGroupQ5;
    private boolean isRadioGroupQ5Scored;

    private EditText mEditTextQ3;
    private boolean isEditTextQ3Scored;
    private EditText mEditTextQ4;
    private boolean isEditTextQ4Scored;

    private CheckBox mCheckBoxQ6Opt1;
    private boolean isCheckBoxQ6Opt1Scored;
    private CheckBox mCheckBoxQ6Opt2;
    private boolean isCheckBoxQ6Opt2Scored;
    private CheckBox mCheckBoxQ6Opt3;
    private boolean isCheckBoxQ6Opt3Scored;
    private CheckBox mCheckBoxQ6Opt4;
    private boolean isCheckBoxScored;

    private Button displayButton;

    Context mContext;
    int score;
    private static final String LOG_TAG = QuizAppActivityFragment.class.getSimpleName();

    public QuizAppActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quiz_app, container, false);
        initViews(rootView);
        initListeners();


        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkboxQuestions();
                edittextQuestions();
                Toast.makeText(mContext, "Score " + score, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void checkboxQuestions() {
        if ((mCheckBoxQ6Opt1.isChecked() &&
                mCheckBoxQ6Opt2.isChecked() &&
                mCheckBoxQ6Opt3.isChecked() &&
                !mCheckBoxQ6Opt4.isChecked() &&
                !isCheckBoxScored)) {
            score++;
            isCheckBoxScored = true;
            Log.d(LOG_TAG, "Post CheckBox Score " + score);
        }
    }

    private void edittextQuestions() {
        String edittextQ3 = mEditTextQ3.getText().toString().toLowerCase();
        Log.d(LOG_TAG, "Question 3 " + edittextQ3);
        String edittextQ4 = mEditTextQ4.getText().toString().toLowerCase();
        Log.d(LOG_TAG, "Question 3 " + edittextQ4);

        if (edittextQ3 != null && !edittextQ3.equals("")) {
            if (!isEditTextQ3Scored) {
                String answer = getResources().getString(R.string.saturn).toLowerCase();
                if (edittextQ3.equals(answer)) {
                    score++;
                    isEditTextQ3Scored = true;
                }
            }
        }

        if (edittextQ3 != null && !edittextQ4.equals("")) {
            if (!isEditTextQ4Scored) {
                String answer = getResources().getString(R.string.armstrong).toLowerCase();
                if (edittextQ4.equals(answer)) {
                    score++;
                    isEditTextQ3Scored = true;
                }
            }
        }

    }

    private void initViews(View view) {
        mContext = view.getContext();
        mRadioGroupQ1 = (RadioGroup) view.findViewById(R.id.radiogrp_q1);
        mRadioGroupQ2 = (RadioGroup) view.findViewById(R.id.radiogrp_q2);
        mRadioGroupQ5 = (RadioGroup) view.findViewById(R.id.radiogrp_q5);
        mEditTextQ3 = (EditText) view.findViewById(R.id.q3_edittext);
        mEditTextQ4 = (EditText) view.findViewById(R.id.q4_edittext);
        mCheckBoxQ6Opt1 = (CheckBox) view.findViewById(R.id.chkbox_q6_opt1);
        mCheckBoxQ6Opt2 = (CheckBox) view.findViewById(R.id.chkbox_q6_opt2);
        mCheckBoxQ6Opt3 = (CheckBox) view.findViewById(R.id.chkbox_q6_opt3);
        mCheckBoxQ6Opt4 = (CheckBox) view.findViewById(R.id.chkbox_q6_opt4);
        displayButton = (Button) view.findViewById(R.id.display_button);
        isRadioGroupQ1Scored = false;
        isRadioGroupQ2Scored = false;
        isRadioGroupQ5Scored = false;
        isEditTextQ3Scored = false;
        isEditTextQ4Scored = false;
        isCheckBoxScored = false;
//        isCheckBoxQ6Opt1Scored = false;
//        isCheckBoxQ6Opt2Scored = false;
//        isCheckBoxQ6Opt3Scored = false;
        score = 0;
    }

    private void initListeners() {
        mRadioGroupQ1.setOnCheckedChangeListener(mRadioGroupListener);
        mRadioGroupQ2.setOnCheckedChangeListener(mRadioGroupListener);
        mRadioGroupQ5.setOnCheckedChangeListener(mRadioGroupListener);
//        mCheckBoxQ6Opt1.setOnCheckedChangeListener(mCheckBoxListener);
//        mCheckBoxQ6Opt2.setOnCheckedChangeListener(mCheckBoxListener);
//        mCheckBoxQ6Opt3.setOnCheckedChangeListener(mCheckBoxListener);
    }

    private RadioGroup.OnCheckedChangeListener mRadioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radiobtn_q1_opt3:
                    if (isRadioGroupQ1Scored) {
                        Toast.makeText(mContext, "q1_opt3", Toast.LENGTH_SHORT).show();
                        isRadioGroupQ1Scored = true;
                    }
                    break;
                case R.id.radiobtn_q2_opt3:
                    if (isRadioGroupQ2Scored) {
                        Toast.makeText(mContext, "q2_opt3", Toast.LENGTH_SHORT).show();
                        isRadioGroupQ2Scored = true;
                    }
                    break;
                case R.id.radiobtn_q5_opt1:
                    if (isRadioGroupQ5Scored) {
                        Toast.makeText(mContext, "q3_opt1", Toast.LENGTH_SHORT).show();
                        isRadioGroupQ5Scored = true;
                    }
                    break;
            }
        }
    };

//    private CompoundButton.OnCheckedChangeListener mCheckBoxListener = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            switch (compoundButton.getId()) {
//                case R.id.chkbox_q6_opt1:
//                    if (mCheckBoxQ6Opt1.isChecked() && !isCheckBoxQ6Opt1Scored) {
//                        isCheckBoxQ6Opt1Scored = true;
//                        Log.d(LOG_TAG, "Q6O1");
//                    }
//                    if (isAllCorrectCheckBoxChecked()) {
//                        Toast.makeText(mContext, "q6_opt1", Toast.LENGTH_SHORT).show();
//                        isCheckBoxScored = true;
//                        Log.d(LOG_TAG, "added");
//                    }
//                    break;
//                case R.id.chkbox_q6_opt2:
//                    if (mCheckBoxQ6Opt2.isChecked() && !isCheckBoxQ6Opt2Scored) {
//                        isCheckBoxQ6Opt2Scored = true;
//                        Log.d(LOG_TAG, "Q6O2");
//                    }
//                    if (isAllCorrectCheckBoxChecked()) {
//                        Toast.makeText(mContext, "q6_opt2", Toast.LENGTH_SHORT).show();
//                        isCheckBoxScored = true;
//                        Log.d(LOG_TAG, "added");
//                    }
//                    break;
//                case R.id.chkbox_q6_opt3:
//                    if (mCheckBoxQ6Opt3.isChecked() && !isCheckBoxQ6Opt3Scored) {
//                        isCheckBoxQ6Opt3Scored = true;
//                        Log.d(LOG_TAG, "Q6O3");
//                    }
//                    if (isAllCorrectCheckBoxChecked()) {
//                        Toast.makeText(mContext, "q6_opt3", Toast.LENGTH_SHORT).show();
//                        isCheckBoxQ6Opt3Scored = true;
//                        isCheckBoxScored = true;
//                        Log.d(LOG_TAG, "added");
//                    }
//                    break;
//            }
//        }
//    };
//
//    private boolean isAllCorrectCheckBoxChecked() {
//        return ((isCheckBoxQ6Opt1Scored &&
//                isCheckBoxQ6Opt2Scored &&
//                isCheckBoxQ6Opt3Scored &&
//                mCheckBoxQ6Opt1.isChecked() &&
//                mCheckBoxQ6Opt2.isChecked() &&
//                mCheckBoxQ6Opt3.isChecked() &&
//                !mCheckBoxQ6Opt4.isChecked() &&
//                !isCheckBoxScored));
//    }
//
//    public void displayScore(View view) {
//        if (view.getId() == R.id.display_button) {
//            Log.d(LOG_TAG, "work");
//        }
//    }
}
