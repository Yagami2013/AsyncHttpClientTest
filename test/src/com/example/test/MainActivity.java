package com.example.test;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.networkbench.agent.impl.NBSAppAgent;
import com.newrelic.agent.android.NewRelic;

public class MainActivity extends Activity {
	private String tag="ytt";
	private String url="http://update.networkbench.com/client/updateInfo.xml.5.3.6";
	private String strURL = "http://www.xiaoying.tv/js/jquery.js";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
//		NBSAppAgent.setLicenseKey("7f9f10fe4f5e403281aecf9dcb18d587").start(this);
		NewRelic.withApplicationToken(
				"AA636263f7040a37e69fcdc349dec8c95e0a5562f4"
				).start(this.getApplication());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button=(Button)findViewById(R.id.mButton);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				testAsyncHttpClient();	
				AsyncHttpClient client = new AsyncHttpClient();
				client.get(strURL,new AsyncHttpResponseHandler() {
					
					@Override
					public void onSuccess(int statusCode,Header[] headers, byte[] responseBody) {
						System.out.println("status code:"+statusCode);
						System.out.println("response size:"+responseBody.length);
					}

					@Override
					public void onFailure(int statusCode,Header[] headers, byte[] responseBody,Throwable error) {
						error.printStackTrace(System.out);
					}
				});
			}
		});
	}
}
