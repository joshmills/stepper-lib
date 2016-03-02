package jmills.co.stepperlib.example;

import jmills.co.stepperlib.model.Step;
import jmills.co.stepperlib.model.StepFragment;

/**
 * Created by joshmills on 02/03/16.
 */
public class ExampleStep extends Step {

    public ExampleStep(String title) {
        super(title);
    }

    @Override
    public StepFragment getFragment() {
        return ExampleStepFragment.newInstance(getTitle(), "Content...");
    }
}
