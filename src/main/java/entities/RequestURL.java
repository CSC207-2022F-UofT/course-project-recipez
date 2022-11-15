package entities;

/**
 * Entity representing a URL to access an API endpoint with
 */
public class RequestURL {
    private final String url;
    public RequestURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
