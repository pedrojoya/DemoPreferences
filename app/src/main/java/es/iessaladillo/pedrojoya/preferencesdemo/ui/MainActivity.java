package es.iessaladillo.pedrojoya.preferencesdemo.ui;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.preferencesdemo.R;
import es.iessaladillo.pedrojoya.preferencesdemo.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        MainActivityViewModel viewModel = ViewModelProviders.of(this).get(
            MainActivityViewModel.class);
        setupActionBar();
        viewModel.getCompanyName().observe(this, this::setTitle);
        if (savedInstanceState == null) {
            navigateToStartFragment();
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
        }
    }

    private void navigateToStartFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,
            MainFragment.newInstance()).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
