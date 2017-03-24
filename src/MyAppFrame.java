/**
 * Created by (Mary) on 17.03.2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyAppFrame extends JFrame {
    private PicturePanel picturePanel;

    public MyAppFrame() {
        super("Окно загрузки") ;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        picturePanel = new PicturePanel();

        container.add(picturePanel);

        JButton button = new JButton("Выбрать файл");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setAlignmentY(BOTTOM_ALIGNMENT);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    picturePanel.setImageFile(file);
                    //label.setText(file.getName());
                }
            }
        });

        container.add(button);

        setPreferredSize(new Dimension(260, 220));
        pack();
        setVisible(true);
    }
    PicturePanel getPicturePanel() {
        return picturePanel;
    }
}
