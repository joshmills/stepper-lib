package jmills.co.stepperlib.model;

import android.app.Fragment;
import android.content.Context;

/**
 * Created by joshmills on 02/03/16.
 */
public abstract class StepFragment extends Fragment {

    public interface OnPageCompletedListener {
        void onCompleted();
        void onIncomplete();
    }

    protected OnPageCompletedListener pageCompletedListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        pageCompletedListener = (OnPageCompletedListener) getActivity();
    }

    public abstract boolean isStepComplete();

}
