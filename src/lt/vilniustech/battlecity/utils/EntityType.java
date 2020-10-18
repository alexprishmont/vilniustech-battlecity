package lt.vilniustech.battlecity.utils;

import lt.vilniustech.battlecity.entities.Entity;

final public class EntityType {
    public static final int TYPE_METAL_WALL = 1;
    public static final int TYPE_COMMON_WALL = 2;
    public static final int TYPE_RIVER = 3;
    public static final int TYPE_TREE = 4;
    public static final int TYPE_PLAYER = 5;
    public static final int TYPE_HOME = 6;
    public static final int TYPE_NPC = 7;

    public static <T> T isEntity(Entity entity, Class<T> type) {
        try {
            return type.cast(entity);
        } catch (ClassCastException exception) {
            return null;
        }
    }
}
