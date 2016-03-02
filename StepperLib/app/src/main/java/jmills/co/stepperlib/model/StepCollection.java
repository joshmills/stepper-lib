package jmills.co.stepperlib.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshmills on 02/03/16.
 */
public class StepCollection {

    private List<Step> steps;

    public StepCollection() {
        steps = new ArrayList<>();
    }

    public void addStep(Step step) {
        step.setStepNumber(steps.size());
        steps.add(step);
    }

    public Step getStep(int position) {
        return steps.get(position);
    }

    public int getNumberOfSteps() {
        return steps.size();
    }

}
