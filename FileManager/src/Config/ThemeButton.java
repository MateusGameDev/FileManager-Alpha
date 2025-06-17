package Config;

import javax.swing.*;
import java.awt.*;

public class ThemeButton extends JButton {
    private final JPanel mainPanel;
    private final JPanel topPanel;
    private final JLabel headerLabel;
    private final JPanel listPanel;
    private final JList<?> fileList;
    private final JPanel actionsPanel;
    private final JLabel titleLabel;
    private boolean isDarkTheme;

    public ThemeButton(JPanel mainPanel, JPanel topPanel, JLabel headerLabel,
                       JPanel listPanel, JList<?> fileList, JPanel actionsPanel,
                       JLabel titleLabel, boolean initialDarkTheme) {
        super("Toggle Theme");
        this.mainPanel = mainPanel;
        this.topPanel = topPanel;
        this.headerLabel = headerLabel;
        this.listPanel = listPanel;
        this.fileList = fileList;
        this.actionsPanel = actionsPanel;
        this.titleLabel = titleLabel;
        this.isDarkTheme = initialDarkTheme;

        this.addActionListener(e -> toggleTheme());
        applyTheme();
    }

    public boolean isDarkTheme() {
        return isDarkTheme;
    }

    public void toggleTheme() {
        isDarkTheme = !isDarkTheme;
        applyTheme();
        ThemeConfig.saveTheme(isDarkTheme);
    }

    private void applyTheme() {
        ThemeApplier.applyTheme(
                isDarkTheme, mainPanel, topPanel, headerLabel, listPanel, fileList, actionsPanel, this, titleLabel
        );
        headerLabel.setText(isDarkTheme ? "Current Theme: Dark" : "Current Theme: Light");
    }
}
