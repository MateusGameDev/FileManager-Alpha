import javax.swing.*;
import java.awt.*;
import Config.*;

public class Main {
    public static void main(String[] args) {
        boolean darkTheme = ThemeConfig.loadTheme();

        JFrame window = new JFrame("File Manager");
        window.setSize(500, 350);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("Imgs/folder.png");
        window.setIconImage(icon.getImage());

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Top label/panel
        JLabel headerLabel = new JLabel(darkTheme ? "Current Theme: Dark" : "Current Theme: Light");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 14));
        headerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(headerLabel);
        topPanel.setOpaque(false);

        // Center: file list panel
        FileListPanel fileListPanel = new FileListPanel();

        // Bottom: actions
        JPanel actionsPanel = new JPanel();
        actionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Theme button (needs all references)
        ThemeButton themeButton = new ThemeButton(
                mainPanel, topPanel, headerLabel,
                fileListPanel.getListPanel(), fileListPanel.getFileList(),
                actionsPanel, fileListPanel.getTitleLabel(), darkTheme
        );

        // File actions (add folder/file)
        FileManagerActions fileActions = new FileManagerActions(window, themeButton, fileListPanel);
        for (Component c : fileActions.getComponents()) actionsPanel.add(c);

        // Layout panels
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(fileListPanel, BorderLayout.CENTER);
        mainPanel.add(actionsPanel, BorderLayout.SOUTH);

        // Apply the theme on startup
        ThemeApplier.applyTheme(
                darkTheme, mainPanel, topPanel, headerLabel,
                fileListPanel.getListPanel(), fileListPanel.getFileList(),
                actionsPanel, themeButton, fileListPanel.getTitleLabel()
        );

        window.add(mainPanel);
        window.setVisible(true);
    }
}
