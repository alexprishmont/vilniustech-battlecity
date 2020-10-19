package lt.vilniustech.battlecity.graphics.game.map;

import lt.vilniustech.battlecity.Game;
import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.obstacle.*;
import lt.vilniustech.battlecity.entities.player.BotEntity;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;
import lt.vilniustech.battlecity.graphics.game.Drawable;
import lt.vilniustech.battlecity.graphics.game.map.level.Level;
import lt.vilniustech.battlecity.graphics.game.player.Home;
import lt.vilniustech.battlecity.graphics.game.obstacle.CommonWall;
import lt.vilniustech.battlecity.graphics.game.obstacle.MetalWall;
import lt.vilniustech.battlecity.graphics.game.obstacle.River;
import lt.vilniustech.battlecity.graphics.game.obstacle.Tree;
import lt.vilniustech.battlecity.graphics.game.player.NpcTank;
import lt.vilniustech.battlecity.graphics.game.player.PlayerTank;
import lt.vilniustech.battlecity.utils.EntityType;

import java.awt.*;

public class Map implements Drawable {
    private final Game game;
    private final int[][] model;

    public Map(Level mapLevel, Game game) {
        model = mapLevel.get();
        this.game = game;
        this.initEntities();
    }

    @Override
    public void draw(Graphics graphics) {
        if (game == null) {
            return;
        }

        for (Entity entity : game.getEntities().values()) {
            entity.draw(graphics);
        }
    }

    public boolean isMetalWall(int x, int y) {
        return model[y][x] == EntityType.TYPE_METAL_WALL;
    }

    public boolean isCommonWall(int x, int y) {
        return model[y][x] == EntityType.TYPE_COMMON_WALL;
    }

    public boolean isRiver(int x, int y) {
        return model[y][x] == EntityType.TYPE_RIVER;
    }

    public boolean isTree(int x, int y) {
        return model[y][x] == EntityType.TYPE_TREE;
    }

    public boolean isHome(int x, int y) {
        return model[y][x] == EntityType.TYPE_HOME;
    }

    public boolean isPlayer(int x, int y) {
        return model[y][x] == EntityType.TYPE_PLAYER;
    }

    public boolean isNpc(int x, int y) {
        return model[y][x] == EntityType.TYPE_NPC;
    }

    public int width() {
        return model.length;
    }

    public int height() {
        return model[0].length;
    }

    private void initEntities() {
        for (int y = 0; y < width(); y++) {
            for (int x = 0; x < height(); x++) {
                if (isMetalWall(x, y)) {
                    new MetalWallEntity(game, new MetalWall(x * MetalWall.LENGTH, y * MetalWall.WIDTH));
                }

                if (isCommonWall(x, y)) {
                    new CommonWallEntity(game, new CommonWall(x * CommonWall.LENGTH, y * CommonWall.WIDTH));
                }

                if (isHome(x, y)) {
                    new HomeEntity(game, new Home(x * Home.LENGTH, y * Home.WIDTH));
                }

                if (isPlayer(x, y)) {
                    new PlayerEntity(game, new PlayerTank(x * PlayerTank.LENGTH, y * PlayerTank.WIDTH));
                }

                if (isNpc(x, y)) {
                    new BotEntity(game, new NpcTank(x * NpcTank.LENGTH, y * NpcTank.WIDTH));
                }

                if (isRiver(x, y)) {
                    new RiverEntity(game, new River(x * River.LENGTH, y * River.WIDTH));
                }

                if (isTree(x, y)) {
                    new TreeEntity(game, new Tree(x * Tree.LENGTH, y * Tree.WIDTH));
                }
            }
        }
    }
}
