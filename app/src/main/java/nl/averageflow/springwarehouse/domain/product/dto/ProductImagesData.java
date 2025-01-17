package nl.averageflow.springwarehouse.domain.product.dto;

public class ProductImagesData {
    private Iterable<String> urls;

    public ProductImagesData() {
    }

    public ProductImagesData(final Iterable<String> urls) {
        this.urls = urls;
    }

    public Iterable<String> getUrls() {
        return urls;
    }

    public void setUrls(final Iterable<String> urls) {
        this.urls = urls;
    }
}
