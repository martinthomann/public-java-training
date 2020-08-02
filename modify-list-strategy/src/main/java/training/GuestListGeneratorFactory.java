package training;

import java.util.List;

public interface GuestListGeneratorFactory {
    GuestListGenerator createGuestListGenerator(Type t, List<Vote> guestList);

    public enum Type {
        FILTER, SET, MAP
    }
}
