package es.iessaladillo.pedrojoya.preferencesdemo.base;

import android.content.SharedPreferences;
import android.text.TextUtils;

import androidx.lifecycle.LiveData;

// https://gist.github.com/rharter/1df1cd72ce4e9d1801bd2d49f2a96810
abstract class SharedPreferencesLiveData<T> extends LiveData<T> {

    final SharedPreferences sharedPreferences;
    private final String key;
    private final T defaultValue;

    private final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener =
        new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (TextUtils.equals(key, SharedPreferencesLiveData.this.key)) {
                    setValue(getValueFromPreferences(key, defaultValue));
                }
            }
        };

    SharedPreferencesLiveData(SharedPreferences sharedPreferences, String key, T defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    protected abstract T getValueFromPreferences(String key, T defaultValue);

    @Override
    protected void onActive() {
        super.onActive();
        setValue(getValueFromPreferences(key, defaultValue));
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override
    protected void onInactive() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        super.onInactive();
    }

}
