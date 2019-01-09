package es.iessaladillo.pedrojoya.preferencesdemo.base;


import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class SharedPreferencesFloatLiveData extends SharedPreferencesLiveData<Float> {

    public SharedPreferencesFloatLiveData(SharedPreferences sharedPreferences, String key,
        Float defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    protected Float getValueFromPreferences(String key, Float defaultValue) {
        return sharedPreferences.getFloat(key, defaultValue);
    }

}
