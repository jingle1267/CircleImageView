package com.worthed.circleimageview;

import java.util.ArrayList;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class CircleImageView extends ImageView {

	private final String TAG = CircleImageView.class.getSimpleName();

	private ArrayList<Bitmap> bmps;

	private ImageLoader imageLoader = ImageLoader.getInstance();
	// private DisplayImageOptions options;
	private BitmapUtil bitmapUtil;

	public CircleImageView(Context context) {
		super(context);
		init();
	}

	public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public CircleImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.v(TAG, "width - height : " + getWidth() + " - " + getHeight());
		canvas.drawBitmap(bitmapUtil
				.toRoundBitmap(
						bitmapUtil.zoomBitmap(GroupHeadsFactory.drawableBitmap(bmps, 300, 0), getWidth(), getHeight())
						), 0, 0, null);
		super.onDraw(canvas);
	}

	private void init() {
		bmps = new ArrayList<Bitmap>();
		bitmapUtil = new BitmapUtil();
		// options = new DisplayImageOptions.Builder()
		// .showImageForEmptyUri(R.drawable.ic_empty)
		// .showImageOnFail(R.drawable.ic_error)
		// .resetViewBeforeLoading(true).cacheOnDisk(true)
		// .imageScaleType(ImageScaleType.EXACTLY)
		// .bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true)
		// .displayer(new FadeInBitmapDisplayer(300)).build();
	}

	public void addUri(String uri) {
		bmps.add(BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_empty));
		imageLoader.loadImage(uri,
				new CircleSimpleImageLoadingListener(bmps.size() - 1));
	}

	public void clearUri() {
		bmps.clear();
	}

	class CircleSimpleImageLoadingListener extends SimpleImageLoadingListener {
		private int index;

		public CircleSimpleImageLoadingListener(int index) {
			super();
			this.index = index;
		}

		@Override
		public void onLoadingStarted(String imageUri, View view) {
			Log.d(TAG, "onLoadingStarted() index : " + index);
			super.onLoadingStarted(imageUri, view);
		}

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			Log.i(TAG, "onLoadingComplete() index : " + index);
			if (index < bmps.size()) {
				bmps.set(index, loadedImage);
			}
//			CircleImageView.this.setImageBitmap(bitmapUtil
//					.toRoundBitmap(GroupHeadsFactory.drawableBitmap(bmps, 300,
//							0)));
			invalidate();
			super.onLoadingComplete(imageUri, view, loadedImage);
		}

		@Override
		public void onLoadingFailed(String imageUri, View view,
				FailReason failReason) {
			Log.e(TAG, "onLoadingFailed() uri : " + imageUri);
			super.onLoadingFailed(imageUri, view, failReason);
		}

		@Override
		public void onLoadingCancelled(String imageUri, View view) {
			Log.w(TAG, "onLoadingCancelled() uri : " + imageUri);
			imageLoader.loadImage(imageUri, this);
//			if (index < bmps.size()) {
//				Bitmap bitmap = imageLoader.getMemoryCache().get(imageUri);
//				if (bitmap == null) {
//					bitmap = 
//				}
//				bmps.set(index, imageLoader.getMemoryCache().get(imageUri));
//			}
			super.onLoadingCancelled(imageUri, view);
		}

	}

}
