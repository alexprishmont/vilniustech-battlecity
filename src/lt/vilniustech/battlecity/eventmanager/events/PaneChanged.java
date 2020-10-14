package lt.vilniustech.battlecity.eventmanager.events;

import lt.vilniustech.battlecity.eventmanager.Event;
import lt.vilniustech.battlecity.graphics.gui.FormProvider;

public class PaneChanged extends Event {
    private final FormProvider form;

    public PaneChanged(FormProvider formProvider) {
        this.form = formProvider;
    }

    public FormProvider getForm() {
        return form;
    }
}
