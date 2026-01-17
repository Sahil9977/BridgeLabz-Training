package annotation;

class LegacyAPI {

    @Deprecated
    void oldFeature() {
        System.out.println("Old feature (Deprecated)");
    }
    void newFeature() {
        System.out.println("New feature (Use this)");
    }
}

public class TestDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // shows warning
        api.newFeature();
    }
}
