package lt.vilniustech.battlecity.graphics.gui.menu;

import lt.vilniustech.battlecity.eventmanager.EventManager;
import lt.vilniustech.battlecity.eventmanager.events.ExitButtonPressed;
import lt.vilniustech.battlecity.eventmanager.events.PlayGameButtonPressed;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;
import lt.vilniustech.battlecity.graphics.gui.GUI;
import lt.vilniustech.battlecity.graphics.gui.game.GameForm;

import javax.swing.*;

public class MenuForm implements FormProvider {
    private static final EventManager eventManager = new EventManager(PlayGameButtonPressed.class, ExitButtonPressed.class);
    private static MenuForm form;
    private JPanel menuPanel;
    private JButton playGameBtn;
    private JButton exitBtn;

    public MenuForm() {
        playGameBtn.addActionListener(event -> GUI.getInstance().switchContentPane(new GameForm()));
        exitBtn.addActionListener(event -> System.exit(0));

        form = this;
    }

    public static MenuForm getForm() {
        return form;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public JPanel getPanel() {
        return menuPanel;
    }

    private void createUIComponents() {
        menuPanel = new MenuPanel();
    }
}
