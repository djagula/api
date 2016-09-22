package co.skywatch.api.java_client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SkyWatchAPI {

    private static Logger log = Logger.getLogger(SkyWatchAPI.class);

    public boolean callAPI() {
        
        boolean success = true;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            String url = "https://api.skywatch.co/data/";
            String query = "time/2016-07-11,2016-07-12/location/-71.1043443253471,-42.3150676015829,71.1043443253471,-42.3150676015829,71.1043443253471,42.3150676015829,-71.1043443253471,42.3150676015829,-71.1043443253471,-42.3150676015829/source/Landsat-8/level/1/resolution/30/cloudcover/100/band/Blue/";

            HttpGet httpGet = new HttpGet(url+query);
            
            httpGet.addHeader("Accept" , "application/json");
            httpGet.addHeader("x-api-key", "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxx" );
            
            StringBuilder outputBuilder = new StringBuilder();
            try {
                CloseableHttpResponse response = httpclient.execute(httpGet);
                int status = response.getStatusLine().getStatusCode();
                if (status < 200 || status >= 300) {
                    log.error("SkyWatch API call failed:  " + status);                    
                    success = false;
                } else {
                    BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        outputBuilder.append(line);    
                    }
                }
                response.close();
            } catch (IOException e) {
                log.error("Exception calling SkyWatch API:  ", e);
                success = false;
            } finally {
                httpclient.close();
            }
            
            try {
                final JSONArray earthData = new JSONArray(outputBuilder.toString());
                final int n = earthData.length();
                for (int i = 0; i < n; ++i) {
                  final JSONObject dataset = earthData.getJSONObject(i);
                  log.debug("Dataset download path is:  " + dataset.getString("download_path"));
                }
            } catch (JSONException  e) {
                log.error("Exception parsing SkyWatch API output:  ", e);
                success = false;
            }
        } catch (IOException e) {
            log.error("Exception connecting to SkyWatch API:  ", e);
            success = false;
        }
        
        return success;
    }
    
}
