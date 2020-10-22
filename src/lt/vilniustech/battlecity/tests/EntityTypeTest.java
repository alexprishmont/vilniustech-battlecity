package lt.vilniustech.battlecity.tests;

import lt.vilniustech.battlecity.entities.player.BotEntity;
import lt.vilniustech.battlecity.entities.player.PlayerEntity;
import lt.vilniustech.battlecity.game.Game;
import lt.vilniustech.battlecity.graphics.game.player.PlayerTank;
import lt.vilniustech.battlecity.utils.EntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTypeTest {

    @DisplayName("Check if static method isEntity returns proper entity type.")
    @Test
    public void shouldReturnEntityType() {
        PlayerEntity playerEntity = new PlayerEntity(new Game(), new PlayerTank(0, 0));
        assertEquals(
                playerEntity,
                EntityType.isEntity(
                        playerEntity,
                        PlayerEntity.class
                )
        );
    }

    @DisplayName("Check if static method isEntity returns null if catches an exception while casting type.")
    @Test
    public void shouldReturnNull() {
        PlayerEntity playerEntity = new PlayerEntity(new Game(), new PlayerTank(0, 0));
        assertNull(
                EntityType.isEntity(
                        playerEntity,
                        BotEntity.class
                )
        );
    }
}