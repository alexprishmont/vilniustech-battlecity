package lt.vilniustech.battlecity.graphics;

public interface Map {
    int getWidth();
    int getHeight();
    boolean isMetalWall(int y, int x);
    boolean isCommonWall(int y, int x);
    boolean isPlayerSpot(int y, int x);
    boolean isNPCSpot(int y, int x);
    boolean isTreeSpot(int y, int x);
    boolean isRiverSpot(int y, int x);
}
