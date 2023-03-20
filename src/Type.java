public enum Type {
    WORK("рабочая"),
    PERSONAL("личная"),
    DEFOLT("Дефолт");
    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
