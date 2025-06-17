package Config;

import java.util.Properties;
import java.io.*;

public class ThemeConfig {
    private static final String CONFIG_FILE = "theme.properties";

    public static void saveTheme(boolean isDark) {
        Properties props = new Properties();
        props.setProperty("darkTheme", Boolean.toString(isDark));
        try (FileOutputStream out = new FileOutputStream(CONFIG_FILE)) {
            props.store(out, "Theme Preference");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean loadTheme() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(CONFIG_FILE)) {
            props.load(in);
            return Boolean.parseBoolean(props.getProperty("darkTheme", "true"));
        } catch (IOException e) {
            return true; // Default: dark theme
        }
    }
}
