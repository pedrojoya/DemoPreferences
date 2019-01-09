package es.iessaladillo.pedrojoya.preferencesdemo.base;


import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class SharedPreferencesBooleanLiveData extends SharedPreferencesLiveData<Boolean> {

    public SharedPreferencesBooleanLiveData(SharedPreferences sharedPreferences, String key,
        Boolean defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    protected Boolean getValueFromPreferences(String key, Boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

}
