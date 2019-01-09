package es.iessaladillo.pedrojoya.preferencesdemo.base;


import android.content.SharedPreferences;

@SuppressWarnings("unused")
public class SharedPreferencesLongLiveData extends SharedPreferencesLiveData<Long> {

    public SharedPreferencesLongLiveData(SharedPreferences sharedPreferences, String key,
        Long defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    protected Long getValueFromPreferences(String key, Long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

}
