package jmills.co.stepperlib.example.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import jmills.co.stepperlib.R;
import jmills.co.stepperlib.model.StepFragment;

/**
 * Created by joshmills on 02/03/16.
 */
public class SelectCampaignSettingsFragment extends StepFragment {

    private TextWatcher fieldWatcher;

    private EditText mTitle;
    private EditText mDescription;

    public static SelectCampaignSettingsFragment newInstance() {
        return new SelectCampaignSettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_campaign_settings, container, false);

        mTitle = (EditText) view.findViewById(R.id.et_campaign_title);
        mDescription = (EditText) view.findViewById(R.id.et_campaign_description);

        fieldWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                testCompleted();
            }
        };

        mTitle.addTextChangedListener(fieldWatcher);
        mDescription.addTextChangedListener(fieldWatcher);

        return view;
    }

    private void testCompleted() {
        if ((mTitle.getText().length() > 0) && (mDescription.getText().length() > 0)) {
            super.pageCompletedListener.onCompleted();
        } else {
            super.pageCompletedListener.onIncomplete();
        }
    }

    @Override
    public boolean isStepComplete() {
        return false;
    }

}
