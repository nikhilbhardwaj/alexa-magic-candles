package in.nikhilbhardwaj.candles.alexa.intent;

import java.util.Optional;

/**
 * Only forward calls to our iot devices that it understands.
 * This is not intended to stop malicious actions akin to SQL injection where someone passes in actions that can get
 * the device to do things that weren't originally intended but this is to instead fail fast and provide the user
 * feedback that this action is unsupported.
 */
public enum SupportedActions {
    ON("on"),
    OFF("off"),
    FLICKER("flicker"),
    GLOW("glow"),
    YELLOW("yellow"),
    WHITE("white"),
    PURPLE("purple"),
    GREEN("green"),
    BLUE("blue"),
    PINK("pink"),
    RED("red"),
    TEAL("teal");

    SupportedActions(String actionName) {
        this.actionName = actionName;
    }

    private String actionName;

    public String actionName() {
        return actionName;
    }

    public static Optional<SupportedActions> fromActionName(String actionName) {
        for(SupportedActions action : SupportedActions.values()) {
            if(action.actionName().equalsIgnoreCase(actionName)) {
                return Optional.of(action);
            }
        }
        return Optional.empty();
    }

}
