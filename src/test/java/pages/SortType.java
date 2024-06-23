package pages;

public enum SortType {
    NAME_AZ("az"),
    NAME_ZA("za"),
    PRICE_HIGH_TO_LOW("hilo"),
    PRICE_LOW_TO_HIGH("lohi");

    private final String value;

    SortType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
