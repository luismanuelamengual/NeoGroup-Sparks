
package org.neogroup.sparks;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Properties extends java.util.Properties {

    public void loadFromResource (String resourceName) throws IOException {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            load(in);
        }
    }

    public void loadFromFile (String filename) throws IOException {
        try (FileInputStream in = new FileInputStream(filename)) {
            load(in);
        }
    }

    public void set(String key, String value) {
        put(key, value);
    }

    public String get (String key) {
        return get(key, null);
    }

    public String get (String key, String defaultValue) {
        return getProperty(key, defaultValue);
    }

    public int getInt (String key) {
        return getInt(key, 0);
    }

    public int getInt (String key, int defaultValue) {
        String value = getProperty(key);
        return value != null? Integer.parseInt(value) : defaultValue;
    }

    public double getDouble (String key) {
        return getDouble(key, 0);
    }

    public double getDouble (String key, double defaultValue) {
        String value = getProperty(key);
        return value != null? Double.parseDouble(value) : defaultValue;
    }

    public boolean getBoolean (String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean (String key, boolean defaultValue) {
        String value = getProperty(key);
        return value != null? Boolean.parseBoolean(value) : defaultValue;
    }
}