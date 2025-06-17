package Config;

import javax.swing.*;
import java.awt.*;

public class ThemeApplier {
    public static void applyTheme(
            boolean darkTheme,
            JPanel mainPanel,
            JPanel topPanel,
            JLabel headerLabel,
            JPanel listPanel,
            JList<?> fileList,
            JPanel actionsPanel,
            ThemeButton themeButton,
            JLabel titleLabel
    ) {
        Color bg, fg, btnBg, btnFg, listBg, listFg;
        if (darkTheme) {
            bg = Color.DARK_GRAY;
            fg = Color.WHITE;
            btnBg = Color.BLACK;
            btnFg = Color.WHITE;
            listBg = new Color(40, 40, 40);
            listFg = Color.WHITE;
        } else {
            bg = Color.WHITE;
            fg = Color.BLACK;
            btnBg = Color.LIGHT_GRAY;
            btnFg = Color.BLACK;
            listBg = Color.WHITE;
            listFg = Color.BLACK;
        }

        mainPanel.setBackground(bg);
        topPanel.setBackground(bg);
        headerLabel.setForeground(fg);

        listPanel.setBackground(bg);
        fileList.setBackground(listBg);
        fileList.setForeground(listFg);

        actionsPanel.setBackground(bg);

        themeButton.setBackground(btnBg);
        themeButton.setForeground(btnFg);

        if (titleLabel != null) {
            titleLabel.setForeground(fg);
            titleLabel.setBackground(bg);
        }

        for (Component comp : actionsPanel.getComponents()) {
            if (comp instanceof JButton) {
                comp.setBackground(btnBg);
                comp.setForeground(btnFg);
            }
        }
    }
}
