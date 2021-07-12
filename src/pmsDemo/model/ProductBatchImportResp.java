package src.pmsDemo.model;

public class ProductBatchImportResp {
    private String requestId;//请求序列，开发者自定义唯一标识符。
    private Product product;
    private Product resource;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getResource() {
        return resource;
    }

    public void setResource(Product resource) {
        this.resource = resource;
    }

}
