package lt.vilniustech.battlecity.utils;

import lt.vilniustech.battlecity.graphics.gui.FormProvider;

final public class FormType {
    public static <T> T isForm(FormProvider form, Class<T> type) {
        try {
            return type.cast(form);
        } catch (ClassCastException exception) {
            return null;
        }
    }
}
