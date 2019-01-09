package es.iessaladillo.pedrojoya.preferencesdemo.ui;

import android.app.Application;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import es.iessaladillo.pedrojoya.preferencesdemo.R;
import es.iessaladillo.pedrojoya.preferencesdemo.base.SharedPreferencesStringLiveData;

// Debemos extender de AndroidViewModel para poder recibir el objeto Application
// y así tener acceso al contexto de la aplicación, ya que lo necesitamos en el método
// PreferenceManager.getDefaultSharedPreferences y en los getString.
@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends AndroidViewModel {

    private final LiveData<String> companyName;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        // A mi parecer esta es una forma más óptima de observar una determinada preferencica
        // y sus cambios.
        companyName = new SharedPreferencesStringLiveData(PreferenceManager
            .getDefaultSharedPreferences
            (application),
            application.getString(R.string.prefCompany_key),
            application.getString(R.string.prefCompany_defaultValue));
    }

    LiveData<String> getCompanyName() {
        return companyName;
    }

}
