package useCases;

public class FilterResponseModel {
    private final String url_segment;

    public FilterResponseModel(String formatted_url) {
        this.url_segment = formatted_url;
    }

    public String getUrl_segment() {
        return url_segment;
    }
}
