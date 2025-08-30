package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static AppSettings INSTANCE;
    private AppSettings() {

    } // should not be public for true singleton

    public static AppSettings getInstance() {
        // synchronized to be thread-safe, but still allows multiple instances
        synchronized (AppSettings.class) {
            if (INSTANCE == null) {
                INSTANCE = new AppSettings(); // should return the SAME instance each time
            }
            return INSTANCE;
        }
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
