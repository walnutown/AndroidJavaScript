package com.example.androidjavascript;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final WebView webview = (WebView) findViewById(R.id.wv_webtab);
		/* JavaScript must be enabled if you want it to work, obviously */
		webview.getSettings().setJavaScriptEnabled(true);

		/* WebViewClient must be set BEFORE calling loadUrl! */
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageFinished(WebView view, String url) {
				webview.loadUrl("javascript:(function() { " + "document.getElementsByTagName('body')[0].style.color = 'red'; " + "})()");
			}
		});

		webview.loadUrl("http://code.google.com/android");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
