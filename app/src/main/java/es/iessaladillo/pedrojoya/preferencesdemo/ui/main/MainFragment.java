package es.iessaladillo.pedrojoya.preferencesdemo.ui.main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.preferencesdemo.R;
import es.iessaladillo.pedrojoya.preferencesdemo.ui.settings.SettingsFragment;

public class MainFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SharedPreferences sharedPreferences;
    private TextView lblCompanyName;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        setupViews();
    }


    private void setupViews() {
        setupActionBar();
        ViewCompat.requireViewById(requireView(), R.id.btnShowSettings).setOnClickListener(v ->
            navigateToSettings());
        lblCompanyName = ViewCompat.requireViewById(requireView(), R.id.lblCompanyName);
        showCompanyName();
    }

    private void setupActionBar() {
        ActionBar actionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (TextUtils.equals(key, getString(R.string.prefCompany_key))) {
            showCompanyName();
        }
    }

    private void showCompanyName() {
        lblCompanyName.setText(sharedPreferences.getString(getString(R.string.prefCompany_key),
            getString(R.string.prefCompany_defaultValue)));
    }

    private void navigateToSettings() {
        requireFragmentManager().beginTransaction()
            .replace(R.id.container, new SettingsFragment(), SettingsFragment.class.getSimpleName())
            .addToBackStack(SettingsFragment.class.getSimpleName())
            .commit();
    }

}
