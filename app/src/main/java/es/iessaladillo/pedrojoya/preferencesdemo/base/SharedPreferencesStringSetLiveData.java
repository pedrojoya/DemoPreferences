package es.iessaladillo.pedrojoya.preferencesdemo.base;


import android.content.SharedPreferences;

import java.util.Set;

@SuppressWarnings("unused")
public class SharedPreferencesStringSetLiveData extends SharedPreferencesLiveData<Set<String>> {

    public SharedPreferencesStringSetLiveData(SharedPreferences sharedPreferences, String key,
        Set<String> defaultValue) {
        super(sharedPreferences, key, defaultValue);
    }

    @Override
    protected Set<String> getValueFromPreferences(String key, Set<String> defaultValue) {
        return sharedPreferences.getStringSet(key, defaultValue);
    }

}
