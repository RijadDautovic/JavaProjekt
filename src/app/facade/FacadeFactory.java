package app.facade;

public class FacadeFactory {

    private static final Facade FACADE = new FacadeImplentation();

    public static Facade getFacade() {
        return FACADE;
    }

}
