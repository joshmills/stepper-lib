package jmills.co.stepperlib.model;

/**
 * Created by joshmills on 02/03/16.
 */
public class Stepper {

    private int currentStep = 1;
    private StepCollection steps;

    public Stepper() {
        steps = new StepCollection();
    }

    public StepCollection getSteps() {
        return steps;
    }
    public Step getStep() {
        return steps.getStep(currentStep - 1);
    }

    public String getStepToolbarTitle() {
        return String.format("Step %s of %s", currentStep, steps.getNumberOfSteps());
    }

    public void next() {
        if (currentStep < steps.getNumberOfSteps())
            currentStep++;
    }

    public void back() {
        if (currentStep > 1)
            currentStep--;
    }

    public int getCurrentStep() {
        return currentStep;
    }

}
