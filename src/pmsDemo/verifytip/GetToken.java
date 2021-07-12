package src.pmsDemo.verifytip;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Function description.
 *  获取token值
 * @author xxxxxxx
 * @since xxxxxxx
 */
public class GetToken {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetToken.class);
    public static String getToken(String domain, String clientId, String clientSecret) {
        String token = null;
        try {
            HttpPost post = new HttpPost(domain + "/oauth2/v1/token");
            JSONObject keyString = new JSONObject();
            keyString.put("client_id", clientId);
            keyString.put("client_secret", clientSecret);
            keyString.put("grant_type", "client_credentials");
            StringEntity entity = new StringEntity(keyString.toString(), Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpResponse response = httpClient.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(response.getEntity().getContent(), Consts.UTF_8));
                String result = br.readLine();
                JSONObject object = JSON.parseObject(result);
                token = object.getString("access_token");
                LOGGER.info("=========================Get_token_Info=========================：");
                LOGGER.info("token = " + token);
            }
            post.releaseConnection();
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
