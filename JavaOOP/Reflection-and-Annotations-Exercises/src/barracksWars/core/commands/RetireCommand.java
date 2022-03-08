package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String result = "";
        String unitType = this.getData()[1];
        try {
            this.getRepository().removeUnit(unitType);
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
}
