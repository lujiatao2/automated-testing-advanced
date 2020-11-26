package com.lujiatao.c09;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.testng.Assert.assertEquals;

public class HTTPMockTest {

    @Test
    public void testCase_001() throws IOException {
        login("http://localhost:9002/login");
    }

    @Test
    public void testCase_002() throws IOException {
        WireMockServer server = new WireMockServer(options().port(9003));
        server.start();
        configureFor("localhost", 9003);
        stubFor(post(urlEqualTo("/login")).withRequestBody(equalTo("username=zhangsan&password=zhangsan123456"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("{\"code\":0,\"msg\":\"成功！\",\"data\":null}")));
        login("http://localhost:9003/login");
        verify(1, postRequestedFor(urlEqualTo("/login")));
        server.stop();
    }

    @Test
    public void testCase_003() throws IOException {
        configureFor("localhost", 9003);
        stubFor(post(urlEqualTo("/login")).withRequestBody(equalTo("username=zhangsan&password=zhangsan123456"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("{\"code\":0,\"msg\":\"成功！\",\"data\":null}")));
        login("http://localhost:9003/login");
        verify(1, postRequestedFor(urlEqualTo("/login")));
    }

    private void login(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username", "zhangsan"));
        nameValuePairs.add(new BasicNameValuePair("password", "zhangsan123456"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8);
        post.setEntity(urlEncodedFormEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        assertEquals(EntityUtils.toString(response.getEntity()), "{\"code\":0,\"msg\":\"成功！\",\"data\":null}");
    }

}
