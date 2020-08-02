package training;

import java.util.List;

public class GuestListGeneratorFactoryImpl implements GuestListGeneratorFactory {
    @Override
    public GuestListGenerator createGuestListGenerator(Type t, List<Vote> guestList) {
        switch (t) {
            case FILTER: {
                return new SolutionWithFilter(guestList);
            }
            case SET: {
                return new SolutionWithSet(guestList);
            }
            case MAP: {
                return new SolutionWithMap(guestList);
            }
            default:
                throw new IllegalArgumentException("Strategy Type not found!");
        }
    }


}
