package lt.vilniustech.battlecity.graphics.gui.finished;

import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.menu.MenuForm;

import javax.swing.*;
import java.awt.*;

public class FinishedForm implements FormProvider {
    private JButton mainMenuButton;
    private JPanel finishedPanel;
    private JLabel gameOverText;

    public FinishedForm(int score) {
        mainMenuButton.addActionListener(event -> GUI.getInstance().switchContentPane(new MenuForm()));

        gameOverText.setFont(new Font("Time new roman", Font.BOLD, 20));
        gameOverText.setText("Game is finished! Your score: " + score);
    }

    @Override
    public JPanel getPanel() {
        return finishedPanel;
    }
}
