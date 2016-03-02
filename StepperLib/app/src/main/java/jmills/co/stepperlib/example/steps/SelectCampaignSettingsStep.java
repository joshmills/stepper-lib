package jmills.co.stepperlib.example.steps;

import android.app.Activity;

import jmills.co.stepperlib.R;
import jmills.co.stepperlib.example.fragments.SelectCampaignSettingsFragment;
import jmills.co.stepperlib.model.Step;
import jmills.co.stepperlib.model.StepFragment;

/**
 * Created by joshmills on 02/03/16.
 */
public class SelectCampaignSettingsStep extends Step {

    public SelectCampaignSettingsStep(Activity context) {
        super(context.getString(R.string.example_steps_select_campaign_settings_title));
    }

    @Override
    public StepFragment getFragment() {
        return SelectCampaignSettingsFragment.newInstance();
    }
}
