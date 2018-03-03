package issues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class GitHubRestClient {
    @Test
    public void test() throws URISyntaxException, IOException {
        Map<String,String> param=new HashMap<String,String>();
        param.put("state", "closed");
        GitHubRestClient prototype = new GitHubRestClient();
        try{
            String json = prototype.requestIssues("vsominen", "Vydehi@17", param);
            System.out.println(param);
            System.out.println(json);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public String requestIssues(String username, String password, Map<String,String> param) throws URISyntaxException, IOException {
        String jsonContent = null;
        HttpHost target = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        
        URIBuilder uribuilder=new URIBuilder();
        uribuilder.setPath("/repos/SoftwareStudio-Spring2018/githubapi-issues-"+username+"/issues");
        if(param!=null) {
            for(String k:param.keySet()) {
                uribuilder.setParameter(k,param.get(k));
            }
        }
        URI uri=uribuilder.build();
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpResponse response=null;
        try {
             response = httpclient.execute(target, httpget, localContext);
            System.out.println(response.getStatusLine()); 
            //TODO check for status 200 before proceeding

            HttpEntity entity = response.getEntity();

            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));

            jsonContent = reader.readLine();

            EntityUtils.consume(entity);
        }
        catch (ClientProtocolException e) {
            System.out.println("Exception in HTTP Client");
            // TODO properly handle exception
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Exception in IO");
            // TODO properly handle exception
            e.printStackTrace();
        }
        finally {
            //TODO close all resources
            response.close();
            httpclient.close();
        }
        return jsonContent;
    }

}