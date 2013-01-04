package org.collectionspace.installer;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

public class AuthorizedHttpRequestTest {
	
	@Test
	public void testLogin() throws ClientProtocolException, IOException {
		
		AuthorizedHttpRequest client = new AuthorizedHttpRequest("http://httpbin.org/post", "test", "test");
		client.get("http://httpbin.org/get"); 
		
	}

}
