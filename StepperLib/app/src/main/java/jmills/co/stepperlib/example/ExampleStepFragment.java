package jmills.co.stepperlib.example;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jmills.co.stepperlib.R;
import jmills.co.stepperlib.model.StepFragment;

/**
 * Created by joshmills on 02/03/16.
 */
public class ExampleStepFragment extends StepFragment
{

    private static final String STEP_TITLE_TEXT = "STEP_TITLE_TEXT";
    private static final String STEP_TEXT_TEXT = "STEP_TEXT_TEXT";

    private String title;
    private String text;

    private TextView mStepTitle;
    private TextView mStepText;

    public static ExampleStepFragment newInstance(String title, String text) {

        ExampleStepFragment fragment = new ExampleStepFragment();

        Bundle args = new Bundle();
        args.putString(STEP_TITLE_TEXT, title);
        args.putString(STEP_TEXT_TEXT, text);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.example_step, container, false);

        mStepTitle = (TextView) view.findViewById(R.id.step_title);
        mStepText = (TextView) view.findViewById(R.id.step_text);

        Bundle args = getArguments();
        title = args.getString(STEP_TITLE_TEXT);
        text = args.getString(STEP_TEXT_TEXT);

        mStepTitle.setText(title);
        mStepText.setText(text);

        return view;
    }

    @Override
    public boolean isStepComplete() {
        return true;
    }
}
