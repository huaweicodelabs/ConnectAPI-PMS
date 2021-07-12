
package src.pmsDemo.verifytip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Function description.
 * app的描述信息
 * @author xxxxxxx
 * @since xxxxxxx
 */
public class GetAppInfo {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetAppInfo.class);

    public static void getAppInfo(String domain, String clientId, String token, String appId, String lang) {
        HttpGet get = new HttpGet(domain + "/publish/v2/app-info?appid=" + appId + "&lang=" + lang);
        get.setHeader("Authorization", "Bearer " + token);
        get.setHeader("client_id", clientId);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(get);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                BufferedReader br =
                    new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), Consts.UTF_8));
                String result = br.readLine();
                JSONObject object = JSON.parseObject(result);
                LOGGER.info("=========================Get_App_Info=========================：");
                JSONArray array = object.getJSONArray("languages");
                for (Object object2 :array){
                    for (Map.Entry entry:((JSONObject) object2).entrySet()){
                        LOGGER.info(entry.getKey()+"---"+entry.getValue().toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
