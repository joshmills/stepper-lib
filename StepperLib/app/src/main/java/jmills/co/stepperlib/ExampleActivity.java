package jmills.co.stepperlib;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.io.Console;

import jmills.co.stepperlib.example.ExampleStep;
import jmills.co.stepperlib.example.steps.SelectCampaignSettingsStep;
import jmills.co.stepperlib.model.StepFragment;
import jmills.co.stepperlib.model.Stepper;

public class ExampleActivity extends Activity implements StepFragment.OnPageCompletedListener {

    private Toolbar mToolbar;

    private Stepper mStepper;
    private Toolbar mStepperToolbar;
    private Button mNext;
    private Button mBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(mToolbar);

        mStepper = new Stepper();
        mStepper.getSteps().addStep(new SelectCampaignSettingsStep(this));
        mStepper.getSteps().addStep(new ExampleStep("Two"));
        mStepper.getSteps().addStep(new ExampleStep("Three"));

        mStepperToolbar = (Toolbar) findViewById(R.id.step_toolbar);
        mStepperToolbar = (Toolbar) findViewById(R.id.step_toolbar);

        // Set up stepper buttons
        mNext = (Button) findViewById(R.id.stepper_next);
        mBack = (Button) findViewById(R.id.stepper_back);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStepper.next();
                updateStepperPage();
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStepper.back();
                updateStepperPage();
            }
        });

        updateStepperPage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateStepperPage() {
        updateStepperToolbar();
        updateStepperButtonStates();
        updateCurrentStepFragment();
    }

    private void updateStepperToolbar() {
        getActionBar().setTitle(mStepper.getStep().getTitle());
        mStepperToolbar.setTitle(mStepper.getStepToolbarTitle());
    }

    private void updateStepperButtonStates() {
        if (mStepper.getCurrentStep() == 1) {
            mBack.setEnabled(false);
        } else { mBack.setEnabled(true); }

        if (mStepper.getCurrentStep() == mStepper.getSteps().getNumberOfSteps()) {
            mNext.setEnabled(false);
        } else { mNext.setEnabled(true); }
    }

    private void updateStepperButtonStates(boolean isComplete) {

        if (mStepper.getCurrentStep() == 1) {
            mBack.setEnabled(false);
        } else { mBack.setEnabled(true); }

        if (isComplete && (mStepper.getCurrentStep() < mStepper.getSteps().getNumberOfSteps())) {
            mNext.setEnabled(true);
        } else {
            mNext.setEnabled(false);
        }
    }

    private void updateCurrentStepFragment() {
        StepFragment fragment = mStepper.getStep().getFragment();
        getFragmentManager().beginTransaction().replace(R.id.stepper_content, fragment).commit();
        updateStepperButtonStates(fragment.isStepComplete());
    }

    @Override
    public void onCompleted() {
        updateStepperButtonStates(true);
    }

    @Override
    public void onIncomplete() {
        updateStepperButtonStates(false);
    }
}
