package rpg_lab;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    private static final int TARGET_XP = 100;
    private static final String HERO_NAME = "Hero";

    @Test
    public void attackGainsExperienceIfTargetIsDead() {

        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);
        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

        assertEquals(TARGET_XP,hero.getExperience());
    }
}
