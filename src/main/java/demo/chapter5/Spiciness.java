package demo.chapter5;


/**
 * @author wangrq
 */

public enum Spiciness {
    /**
     *
     */
    NOT("1"),
    MILD("2"),
    MEDIUM("3"),
    HOT("4");
    private String value;

    Spiciness(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Spiciness{" +
                "value='" + value + '\'' +
                '}';
    }
}
