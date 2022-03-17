package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GangNeighbourhood implements Neighbourhood {

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        List<Gun> mainPlayerGuns = new ArrayList<>(mainPlayer.getGunRepository().getModels());
        List<Player> civilPlayersList = new ArrayList<>(civilPlayers);

//            for (int i = 0; i < civilPlayersList.size(); i++) {
//                boolean gunCannotFire = false;
//                Player player = civilPlayersList.get(i);
//                ArrayList<Gun> civilPlayerGuns = new ArrayList<>(player.getGunRepository().getModels());
//                for (int j = 0; j < civilPlayerGuns.size(); j++) {
//                    Gun gun = civilPlayerGuns.get(j);
//                    while (mainPlayer.isAlive()) {
//                        if (gun.getTotalBullets() <= 0) {
//                            gunCannotFire = true;
//                            civilPlayerGuns.remove(j);
//
//                            j--;
//                            break;
//                        }
//                        mainPlayer.takeLifePoints(gun.fire());
//                    }
//                }
//            }

        for (int i = 0; i < mainPlayerGuns.size(); i++) {
            Gun gun = mainPlayerGuns.get(i);
            boolean flag = false;
            for (int j = 0; j < civilPlayersList.size(); j++) {
                Player player = civilPlayersList.get(j);
                while (player.isAlive()) {
                    if (gun.getTotalBullets() <= 0) {
                        flag = true;
                        mainPlayerGuns.remove(i);
                        i--;
                        break;
                    }
                    player.takeLifePoints(gun.fire());
                }
                if (flag) {
                    break;
                }
            }
        }

        List<Player> alreadyAliveCivilPlayers = civilPlayersList
                .stream()
                .filter(cp -> cp.getLifePoints() > 0)
                .collect(Collectors.toList());

        if (alreadyAliveCivilPlayers.size() >= 1) {
            for (int i = 0; i < alreadyAliveCivilPlayers.size(); i++) {
                boolean gunCannotFire = false;
                Player player = alreadyAliveCivilPlayers.get(i);
                ArrayList<Gun> civilPlayerGuns = new ArrayList<>(player.getGunRepository().getModels());
                for (int j = 0; j < civilPlayerGuns.size(); j++) {
                    Gun gun = civilPlayerGuns.get(j);
                    while (mainPlayer.isAlive()) {
                        if (gun.getTotalBullets() <= 0) {
                            gunCannotFire = true;
                            civilPlayerGuns.remove(j);

                            j--;
                            break;
                        }
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                }
            }
        }
    }
}
