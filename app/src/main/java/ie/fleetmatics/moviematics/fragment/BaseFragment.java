package ie.fleetmatics.moviematics.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import ie.fleetmatics.moviematics.ProgressDialogHandler;
import ie.fleetmatics.moviematics.R;
import ie.fleetmatics.moviematics.model.BundleFactory;
import ie.fleetmatics.moviematics.model.ContentType;
import ie.fleetmatics.moviematics.net.FacadeFactory;
import ie.fleetmatics.moviematics.net.FacadeType;
import ie.fleetmatics.moviematics.net.OKHttpClientFacade;
import ie.fleetmatics.moviematics.net.api.ApiContext;
import ie.fleetmatics.moviematics.net.api.ApiImpl;

/**
 * Base Fragment that implements common functionality for all the fragments
 */
public class BaseFragment extends Fragment implements ProgressDialogHandler {

    private ProgressDialog mProgressDialog;
    private boolean showDialog = false;
    protected ApiContext apiContext;
    protected Intent extras;

    public BaseFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        extras = getActivity().getIntent();

        // Initialize the api context and set an api (ApiImpl in this case)
        apiContext = ApiContext.getApiContextHolder();
        apiContext.setApi(new ApiImpl(FacadeFactory.createFacade(FacadeType.OK_HTTP)));
    }

    @Override
    public void onPause() {
        super.onPause();

        showDialog = false;
    }

    /**
     * Creates and shows a ProgressDialog
     */
    @Override
    public void showProgressDialog() {
        showDialog = true;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (showDialog) {
                    mProgressDialog = new ProgressDialog(getActivity());
                    mProgressDialog.setTitle(R.string.please_wait);
                    mProgressDialog.setMessage(getResources().getString(R.string.loading));
                    mProgressDialog.show();
                }
            }
        }, 1);
    }

    /**
     * Hides the ProgressDialog
     */
    @Override
    public void hideProgressDialog() {
        showDialog = false;

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * Method that returns the right bundle
     * @param type
     * @return
     */
    protected Bundle getBundle(ContentType type) {
        return BundleFactory.createBundle(type, extras);
    }

}