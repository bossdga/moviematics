package ie.fleetmatics.moviematics.net;

/**
 * Enum declaring all the facade types
 */
public enum FacadeType {

    OK_HTTP(0), URL_CONNECTION(1);

    private final int typeId;

    FacadeType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

}