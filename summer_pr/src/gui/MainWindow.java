package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JPanel {
    private GraphPanel graphPanel;

    public MainWindow(){
        super.setLayout(new BorderLayout());
        setGraphPanel();
    }

    private void setGraphPanel(){
        graphPanel = new GraphPanel();
        graphPanel.setPreferredSize(new Dimension(9000, 4096));

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(graphPanel);
        scroll.setPreferredSize(new Dimension(750, 500));
        scroll.getViewport().setViewPosition(new Point(4100, 0));
        add(scroll, BorderLayout.CENTER);
        setTopPanel();
        setButtons();
    }

    private void setTopPanel() {
        JLabel info = new JLabel("Dijkstra Algorithm Visualiser by Brigada");
        info.setForeground(new Color(230, 220, 250));
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 191, 255));
        panel.add(info);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(panel, BorderLayout.NORTH);
    }

    private void setButtons(){
        JButton run = new JButton();
        setupIcon(run, "run");
        JButton reset = new JButton();
        setupIcon(reset, "reset");
        final JButton info = new JButton();
        setupIcon(info, "info");
        JButton file = new JButton();
        setupIcon(file, "file");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(DrawUtils.parseColor("#DDDDDD"));
        buttonPanel.add(reset);
        buttonPanel.add(run);
        buttonPanel.add(info);
        buttonPanel.add(file);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphPanel.reset();
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Some hotkeys for project:\n" +
                        "Examples of this hotkeys:\n\n" +
                        "Shift + Right Click: some info about this combination\n" +
                        "Ctrl + C: some info about this combination\n");
            }
        });

        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                } catch (IllegalStateException ise){
                    JOptionPane.showMessageDialog(null, ise.getMessage());
                }
            }
        });

        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphPanel.file();
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupIcon(JButton button, String img){
        try {
            Image icon = ImageIO.read(getClass().getResource(
                    "/resources/" + img + ".png"));
            ImageIcon imageIcon = new ImageIcon(icon);
            button.setIcon(imageIcon);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
