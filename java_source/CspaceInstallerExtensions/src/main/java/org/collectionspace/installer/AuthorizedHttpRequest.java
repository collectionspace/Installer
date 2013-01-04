package org.collectionspace.installer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class AuthorizedHttpRequest {
	
	HttpClient client;
	
	public AuthorizedHttpRequest(String url, String username, String password) throws ClientProtocolException, IOException {
		
		client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("userid", username));
		nvps.add(new BasicNameValuePair("password",password ));
		post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		try {
			client.execute(post);
		} finally {
		    post.releaseConnection();
		}
		
	}
	
	
	public void get(String url) throws ClientProtocolException, IOException {
		
		HttpGet get = new HttpGet(url);
		try {
			client.execute(get);
		} finally {
		    get.releaseConnection();
		}
	}
	
	

}
