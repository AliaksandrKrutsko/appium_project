package driver;

public enum AppiumCapabilities {

    PATH_NAME("D:/Circuit/circuit.apk"),
    DEVICE_NAME("6f7a4f19"),
    PLATFORM_VERSION("4.4.2"),
    PLATFORM_NAME("Android"),
    APP_PACKAGE("com.unify.circuit"),
    APP_ACTIVITY("com.unify.circuit.activities.WelcomeActivity"),
    URL("http://127.0.0.1:4493/wd/hub"),
    AUTOMATION_NAME("UiAutomator2"),
    IMPLICIT_WAIT("80");

    private String myCapability;

    AppiumCapabilities(String capability) {
        myCapability = capability;
    }

    public String get() {
        return myCapability;
    }

}
