package com.pakdata.xwalk.refactor;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/InMemorySharedPreferences.class */
public class InMemorySharedPreferences implements SharedPreferences {
    private final Map<String, Object> mData;

    public InMemorySharedPreferences() {
        this.mData = new HashMap();
    }

    public InMemorySharedPreferences(Map<String, Object> data) {
        this.mData = data;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> unmodifiableMap;
        synchronized (this.mData) {
            unmodifiableMap = Collections.unmodifiableMap(this.mData);
        }
        return unmodifiableMap;
    }

    @Override // android.content.SharedPreferences
    public String getString(String key, String defValue) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return (String) this.mData.get(key);
            }
            return defValue;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String key, Set<String> defValues) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return Collections.unmodifiableSet((Set) this.mData.get(key));
            }
            return defValues;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return ((Integer) this.mData.get(key)).intValue();
            }
            return defValue;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return ((Long) this.mData.get(key)).longValue();
            }
            return defValue;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return ((Float) this.mData.get(key)).floatValue();
            }
            return defValue;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        synchronized (this.mData) {
            if (this.mData.containsKey(key)) {
                return ((Boolean) this.mData.get(key)).booleanValue();
            }
            return defValue;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        boolean containsKey;
        synchronized (this.mData) {
            containsKey = this.mData.containsKey(key);
        }
        return containsKey;
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new InMemoryEditor();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException();
    }

    /* loaded from: xwalk_main_fat-77.3.aar:classes.jar:com/pakdata/xwalk/refactor/InMemorySharedPreferences$InMemoryEditor.class */
    private class InMemoryEditor implements SharedPreferences.Editor {
        private boolean mClearCalled;
        private volatile boolean mApplyCalled;
        private final Map<String, Object> mChanges;

        private InMemoryEditor() {
            this.mChanges = new HashMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String key, String value) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, value);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, values);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String key, int value) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, Integer.valueOf(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String key, long value) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, Long.valueOf(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String key, float value) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, Float.valueOf(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String key, boolean value) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, Boolean.valueOf(value));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String key) {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mChanges.put(key, this);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            synchronized (this.mChanges) {
                if (this.mApplyCalled) {
                    throw new IllegalStateException();
                }
                this.mClearCalled = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            apply();
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            synchronized (InMemorySharedPreferences.this.mData) {
                synchronized (this.mChanges) {
                    if (this.mApplyCalled) {
                        throw new IllegalStateException();
                    }
                    if (this.mClearCalled) {
                        InMemorySharedPreferences.this.mData.clear();
                    }
                    for (Map.Entry<String, Object> entry : this.mChanges.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value == this) {
                            InMemorySharedPreferences.this.mData.remove(key);
                        } else {
                            InMemorySharedPreferences.this.mData.put(key, value);
                        }
                    }
                    this.mApplyCalled = true;
                }
            }
        }
    }
}
