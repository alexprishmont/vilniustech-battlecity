package lt.vilniustech.battlecity.tests;

import lt.vilniustech.battlecity.entities.Entity;
import lt.vilniustech.battlecity.entities.player.BotEntity;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;
import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.game.rules.RulePlayerDied;
import lt.vilniustech.battlecity.graphics.game.player.NpcTank;
import lt.vilniustech.battlecity.graphics.game.player.PlayerTank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RulePlayerDiedTest {
    private RulePlayerDied rule;

    @BeforeEach
    void setUp() {
        rule = new RulePlayerDied();
    }

    @AfterEach
    void tearDown() {
        rule = null;
    }

    @DisplayName("Check if rule checks if entity list doesn't contain any PlayerEntity object.")
    @Test
    void checkWithoutPlayerEntity() {
        List<Entity> entities = new ArrayList<>();

        entities.add(
                new BotEntity(
                        new Game(),
                        new NpcTank(0, 0)
                )
        );

        assertTrue(rule.check(entities));
    }

    @DisplayName("Check if rule returns false when there are player entities in the list.")
    @Test
    void checkWithBotEntities() {
        List<Entity> entities = new ArrayList<>();

        entities.add(
                new PlayerEntity(
                        new Game(),
                        new PlayerTank(0, 0)
                )
        );

        entities.add(
                new BotEntity(
                        new Game(),
                        new NpcTank(0, 0)
                )
        );

        assertFalse(rule.check(entities));
    }
}