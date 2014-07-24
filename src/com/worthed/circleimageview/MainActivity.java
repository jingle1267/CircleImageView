package com.worthed.circleimageview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	
	public static final String IMAGE_URL = "https://github.com/fluidicon.png";

	public static final String IMAGE_URL1 = "http://imgsrc.baidu.com/forum/w%3D580/sign=7d4e089f0924ab18e016e13f05fbe69a/b25ba8ec08fa513d09bf81673d6d55fbb3fbd942.jpg";
	public static final String IMAGE_URL2 = "http://imgsrc.baidu.com/forum/w%3D580/sign=87f25b4c3b292df597c3ac1d8c315ce2/2362ecfdfc039245c5947f6c8694a4c27c1e25d8.jpg";
	public static final String IMAGE_URL3 = "http://www.tilemountain.co.uk/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/p/r/prismatics_prg16_teal_100x100-1600.jpg";
	public static final String IMAGE_URL4 = "http://imgsrc.baidu.com/forum/w%3D580/sign=c7e68dd9a8773912c4268569c8188675/a68f26f79052982243ebf2a7d6ca7bcb0b46d423.jpg";
	public static final String IMAGE_URL5 = "http://t2.gstatic.com/images?q=tbn:ANd9GcTwQHT_I38rmpT6NsqRBkgFGXVq7RbQx_0L0JO06w971N4SWxE6tg";
	public static final String IMAGE_URL6 = "http://imgsrc.baidu.com/forum/pic/item/cf1b9d16fdfaaf513c04750e8c5494eef11f7a98.jpg?v=tbs";
	
	private CircleImageView circleImageView1, circleImageView2, circleImageView3, circleImageView4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		circleImageView1 = (CircleImageView) findViewById(R.id.imageView1);
		circleImageView2 = (CircleImageView) findViewById(R.id.imageView2);
		circleImageView3 = (CircleImageView) findViewById(R.id.imageView3);
		circleImageView4 = (CircleImageView) findViewById(R.id.imageView4);
		
		circleImageView1.addUri(IMAGE_URL1);
		
		circleImageView2.addUri(IMAGE_URL2);
		circleImageView2.addUri(IMAGE_URL6);
		
		circleImageView3.addUri(IMAGE_URL);
		circleImageView3.addUri(IMAGE_URL);
		circleImageView3.addUri(IMAGE_URL);
		
		circleImageView4.addUri(IMAGE_URL1);
		circleImageView4.addUri(IMAGE_URL6);
		circleImageView4.addUri(IMAGE_URL4);
		circleImageView4.addUri(IMAGE_URL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
