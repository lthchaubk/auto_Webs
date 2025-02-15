package utilities.common;

/**
 * Author: chaule
 * Created_at: 15Jun2023
 * Note:
 */
public enum Languages {
    VI("Tiếng Việt"),
    EN("English"),
    ;
    private String text;

    private Languages(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
