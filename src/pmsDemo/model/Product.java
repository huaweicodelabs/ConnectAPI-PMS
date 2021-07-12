package src.pmsDemo.model;



public class Product {
    private String id;
    //开发者自定义商品标识，跟appId唯一确定一个商品。 必须以大小写字母或数字开头，并且只能由大小写字母 (A-Z,a-z)、数字 (0-9)、下划线 (_) 和句点 (.) 组成。同一个应用内商品标识不能重复
    private String productNo;
    private String appId;//应用ID。
    private String productName;//商品名称，支持多语言配置，根据defaultLocale配置此处的商品名称。不支持特殊字符|。
    private String purchaseType;
                    //商品类型，取值范围：
                    /*    consumable：消耗型
                        auto_subscription：自动续费订阅型
                        non_consumable：非消耗型*/
    private String status;//商品状态，支持创建active和inactive状态的商品默认值为inactive
    private String currency;//用于支付的默认币种
    private String country;//国家码
    private String isNeedApprove;//是否需要审批（预留字段，暂未使用
    private String defaultPrice;//默认价格
    private String force;//自动订阅型商品，价格变更之后，对于已订阅用户是否强制涨价。不传默认值为0。
    private String defaultLocale;//默认语言环境
    private String productDesc;//默认商品描述信息
    private String languages;//商品多语言信息
    private String prices;//自定义价格
    private String subGroupId;//订阅分组id
    private String subPeriod;//订阅周期
    private String subPeriodUnit;//订阅周期单位

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIsNeedApprove() {
        return isNeedApprove;
    }

    public void setIsNeedApprove(String isNeedApprove) {
        this.isNeedApprove = isNeedApprove;
    }

    public String getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(String defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public void setDefaultLocale(String defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(String subGroupId) {
        this.subGroupId = subGroupId;
    }

    public String getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(String subPeriod) {
        this.subPeriod = subPeriod;
    }

    public String getSubPeriodUnit() {
        return subPeriodUnit;
    }

    public void setSubPeriodUnit(String subPeriodUnit) {
        this.subPeriodUnit = subPeriodUnit;
    }

    @Override
    public String toString() {
        return "product 【id = " + id + ",productNo = " + productNo + ",appId = " + appId + ",productName = " + productName + ",purchaseType = " + purchaseType +
                ",status = " + status + ",currency = " + currency + ",country = " + country + ",isNeedApprove = " + isNeedApprove + ",defaultPrice = " + defaultPrice+
                ",force = " + force + ",defaultLocale = " + defaultLocale + ",productDesc = " + productDesc + ",languages = " + languages + ",prices = " + prices
                + ",subGroupId = " + subGroupId + ",subPeriodUnit = " + subPeriodUnit + "】";
    }
}