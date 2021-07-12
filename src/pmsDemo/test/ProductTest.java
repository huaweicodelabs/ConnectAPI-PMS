package src.pmsDemo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import src.pmsDemo.impl.UpLoadProduct;
import src.pmsDemo.model.Product;
import src.pmsDemo.model.ProductBatchImportResp;
import src.pmsDemo.verifytip.GetAppInfo;
import src.pmsDemo.verifytip.GetToken;
import sun.util.calendar.BaseCalendar;
import java.util.UUID;

public class ProductTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTest.class);

    /**
     * Token domain name.
     */
    private static String domain = "https://connect-api.cloud.huawei.com/api/";

    /**
     * clientId：客户端ID，即创建API客户端中生成的“客户端ID”
     */
    private static String clientId = "******";

    /**
     * clientSecret：客户端密钥，即创建API客户端中生成的“密钥”
     */
    private static String clientSecret = "******";

    /**
     * App ID：查询的应用ID
     */
    private static String appId = "******";

    public static void main(String[] args) {

        // Obtain the token.
        String token = GetToken.getToken(domain, clientId, clientSecret);

        // Query app information.
        GetAppInfo.getAppInfo(domain, clientId, token, appId, "zh-CN");

        Product req = new Product();
        req.setProductNo(UUID.randomUUID().toString().replaceAll("\\-",""));
        req.setAppId(appId);;
        req.setProductName("increase--"+UUID.randomUUID().toString().replaceAll("\\-",""));
        /**
         * consumable：消耗型  auto_subscription：自动续费订阅型 non_consumable：非消耗型
         */
        req.setPurchaseType("consumable");
        req.setStatus("active");
        req.setCurrency("CNY");
        req.setCountry("CN");
        req.setIsNeedApprove("N");
        req.setDefaultPrice("123");
        req.setDefaultLocale("zh_CN");
        req.setProductDesc("默认商品信息。不支持特殊字符。");

        ProductBatchImportResp productBatchImportResp = new ProductBatchImportResp();
        productBatchImportResp.setProduct(req);
        productBatchImportResp.setRequestId(UUID.randomUUID().toString().replaceAll("\\-",""));

        //添加
        UpLoadProduct.batchImportProducts(domain,clientId,token,appId,productBatchImportResp);

        //更新
        req.setProductNo("ac1c3553ae6a48908f279c79a1688268");
        req.setProductName("update--"+UUID.randomUUID().toString().replaceAll("\\-",""));
        productBatchImportResp.setResource(req);
        productBatchImportResp.setProduct(null);
        UpLoadProduct.batchUpdateProductInfo(domain,clientId,token,appId,productBatchImportResp);

        //查询
        UpLoadProduct.getProductInfoDetail(domain,clientId,token,appId,"ac1c3553ae6a48908f279c79a1688268");
    }
}
