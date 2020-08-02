package training;

public class ServiceLocator {
    private ServiceLocator() {
    }

    private static final ServiceLocator INSTANCE = new ServiceLocator();

    public static ServiceLocator getInstance() {
        return INSTANCE;
    }

    public GuestListGeneratorFactory newGuestListGeneratorFactory() {
        return new GuestListGeneratorFactoryImpl();
    }
}
