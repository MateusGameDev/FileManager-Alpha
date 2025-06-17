package Config;

import javax.swing.*;
import java.awt.*;

public class FileManagerActions extends JPanel {
    public FileManagerActions(JFrame parentWindow, ThemeButton themeButton, FileListPanel fileListPanel) {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton newFolderButton = new JButton("New Folder");
        JButton newFileButton = new JButton("New File");

        newFolderButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(parentWindow, "Enter folder name:");
            if (name != null && !name.trim().isEmpty()) {
                fileListPanel.addFolder(name.trim());
            }
        });

        newFileButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(parentWindow, "Enter file name:");
            if (name != null && !name.trim().isEmpty()) {
                fileListPanel.addFile(name.trim());
            }
        });

        add(themeButton);
        add(newFolderButton);
        add(newFileButton);
    }
}
