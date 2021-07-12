package src.pmsDemo.impl;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import src.pmsDemo.model.Product;
import src.pmsDemo.model.ProductBatchImportResp;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class  UpLoadProduct {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpLoadProduct.class);

    /**
     * 新增商品信息
     * @param domain
     * @param clientId
     * @param authorization
     * @param appId
     * @param productBatchImportResp
     * @return
     */
    public static ProductBatchImportResp batchImportProducts(String domain, String clientId, String authorization,
                                                             String appId, ProductBatchImportResp productBatchImportResp) {
        String url = domain + "/pms/product-price-service/v1/manage/product";
        HttpPost post = new HttpPost(url);
        setHttpHead(clientId, authorization, appId, post);
        StringEntity entity = new StringEntity(JSON.toJSONString(productBatchImportResp), ContentType.create("application/json", "UTF-8"));
        post.setEntity(entity);
        String result = getApiResp(post);
        LOGGER.info("=========================Increase_Product_Info=========================："+productBatchImportResp.getProduct().getProductNo());
        LOGGER.info(result);
        return null;
    }

    /**
     * 更新商品信息
     * @param domain
     * @param clientId
     * @param authorization
     * @param appId
     * @param productBatchImportResp
     * @return
     */
    public static ProductBatchImportResp batchUpdateProductInfo(String domain, String clientId, String authorization,
                                                                String appId, ProductBatchImportResp productBatchImportResp) {
        String url = domain + "/pms/product-price-service/v1/manage/product";
        HttpPut put = new HttpPut(url);
        setHttpHead(clientId, authorization, appId, put);
        StringEntity entity =
                new StringEntity(JSON.toJSONString(productBatchImportResp), ContentType.create("application/json", "UTF-8"));
        put.setEntity(entity);
        String result = getApiResp(put);
        LOGGER.info("=========================Update_Product_Info=========================：");
        LOGGER.info("productNo: " + productBatchImportResp.getResource().getProductNo()+ "; productName: "+productBatchImportResp.getResource().getProductName());
        LOGGER.info(result);
        return null;
    }

    /**
     * 查询商品信息
     * @param domain
     * @param clientId
     * @param authorization
     * @param appId
     * @param productNo
     * @return
     */
    public static Product getProductInfoDetail(String domain, String clientId, String authorization,
                                               String appId, String productNo) {
        String url = domain + "/pms/product-price-service/v1/manage/product";
        HttpGet get = new HttpGet(url + "?productNo=" + productNo);
        setHttpHead(clientId, authorization, appId, get);
        String result = getApiResp(get);
        LOGGER.info("=========================Inquire_Product_Info=========================："+productNo);
        LOGGER.info(result);
        return null;
    }

    //如下示例公告方法
    private static void setHttpHead(String clientId, String authorization, String appId,
                                    HttpRequestBase requestEntity) {
        requestEntity.setHeader("Authorization", "Bearer " + authorization);
        requestEntity.setHeader("client_id", clientId);
        requestEntity.setHeader("appId", appId);
    }

    private static String getApiResp(HttpRequestBase requestEntity) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(requestEntity);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Consts.UTF_8));
                String result = br.readLine();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
