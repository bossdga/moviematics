package ie.fleetmatics.moviematics.model;

/**
 * Enum declaring all the content types
 */
public enum ContentType {

    MOVIE(0), TVSHOW(1), PERSON(2);

    private final int typeId;

    ContentType(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public static ContentType contentByInt(int id) {
        for (ContentType contentType : values()) {
            if (contentType.typeId == id) {
                return contentType;
            }
        }
        throw new IllegalArgumentException("Invalid Type id: " + id);
    }

}