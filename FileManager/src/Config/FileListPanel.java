package Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel for displaying created folders and files in a list, with icons.
 */
public class FileListPanel extends JPanel {
    private DefaultListModel<ItemEntry> listModel;
    private JList<ItemEntry> fileList;
    private java.util.List<ItemEntry> createdItems;
    private JLabel titleLabel;

    private ImageIcon folderIcon;
    private ImageIcon fileIcon;

    public FileListPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        createdItems = new ArrayList<>();

        // Load icons (ensure paths are correct)
        folderIcon = new ImageIcon("Imgs/folder.png");
        fileIcon = new ImageIcon("Imgs/file.png");

        // Custom cell renderer for icons
        fileList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus
                );

                if (value instanceof ItemEntry) {
                    ItemEntry entry = (ItemEntry) value;
                    label.setText(entry.displayName);
                    label.setIcon(entry.isFolder ? folderIcon : fileIcon);
                }
                return label; // Must return Component
            }
        });

        titleLabel = new JLabel("Created folders and files:");
        add(titleLabel);
        add(new JScrollPane(fileList));
    }

    // Helper class for folder/file entries
    public static class ItemEntry {
        public final String displayName;
        public final boolean isFolder;

        public ItemEntry(String displayName, boolean isFolder) {
            this.displayName = displayName;
            this.isFolder = isFolder;
        }

        @Override
        public String toString() {
            return displayName;
        }
    }

    public void addFolder(String name) {
        ItemEntry entry = new ItemEntry(name, true);
        createdItems.add(entry);
        listModel.addElement(entry);
    }

    public void addFile(String name) {
        ItemEntry entry = new ItemEntry(name, false);
        createdItems.add(entry);
        listModel.addElement(entry);
    }

    public JList<ItemEntry> getFileList() {
        return fileList;
    }

    public JPanel getListPanel() {
        return this;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }
}
