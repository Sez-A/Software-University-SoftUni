package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private Player mainPlayer;
    private List<Player> civilPlayers;
    private List<Gun> guns;

    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayList<>();
    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        this.civilPlayers.add(civilPlayer);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }

        if (gun == null) {
            return GUN_TYPE_INVALID;
        }

        this.guns.add(gun);

        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            Gun gun = guns.remove(0);
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                Gun gun = guns.remove(0);
                civilPlayer.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
            }
        }

        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(mainPlayer, civilPlayers);
        int beforeFightCivilPlayers = civilPlayers.size();

        civilPlayers = civilPlayers
                .stream()
                .filter(cp -> cp.getLifePoints() > 0)
                .collect(Collectors.toList());

        int deadCivilPlayersCnt = beforeFightCivilPlayers - civilPlayers.size();

        if (mainPlayer.getLifePoints() == 100 && civilPlayersNotDeadOrHarmed(civilPlayers)) {
            return FIGHT_HOT_HAPPENED;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator());
        sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayersCnt))
                .append(System.lineSeparator());
        sb.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size()))
                .append(System.lineSeparator());
        return sb.toString().trim();
    }

    private boolean civilPlayersNotDeadOrHarmed(List<Player> civilPlayers) {

        if (civilPlayers.isEmpty()) {
            return false;
        }

        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getLifePoints() < 50) {
                return false;
            }
        }
        return true;
    }
}
