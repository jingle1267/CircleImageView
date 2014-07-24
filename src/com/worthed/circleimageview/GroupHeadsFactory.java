package com.worthed.circleimageview;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class GroupHeadsFactory {
	private static final int space = 2;

	public static Bitmap drawableBitmap(ArrayList<Bitmap> bms, int size,
			int childRound) {
		if (bms.size() < 1)
			return null;
		if (bms.size() == 1) {
			return drawableOneBitmap(bms.get(0), size, childRound);
		}else if(bms.size() == 2)
		{
			return drawable2Bitmap(bms,size,childRound);
		}else if(bms.size() == 3)
		{
			return drawable3Bitmap(bms,size,childRound);
		}
		else {
			ArrayList<Bitmap> newBms = new ArrayList<Bitmap>(0); 
			for(int i =0;i<bms.size() ;i++)
			{
				if(i<=3)
				{
					newBms.add(bms.get(i));
				}
				
			}
			return drawable4Bitmap(newBms, size, childRound);
		}
	}

	public static Bitmap drawableOneBitmap(Bitmap bm, int size, int childRound) {
		int cSize = size - 2 * space;
		Bitmap pBm = Bitmap.createBitmap(size, size, Config.ARGB_8888);
		Canvas canvas = new Canvas(pBm);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(2, 2, cSize, cSize);
		final Rect cRect = new Rect(0, 0, bm.getWidth(), bm.getHeight());
		final RectF rectF = new RectF(rect);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, childRound, childRound, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bm, cRect, rect, paint);
		return pBm;
	}

	private static Bitmap drawable4Bitmap(ArrayList<Bitmap> bms, int size,
			int childRound) {
		int cSize = (size - 3 * space) / 2;
		Bitmap pBm = Bitmap.createBitmap(size, size, Config.ARGB_8888);
		Canvas canvas = new Canvas(pBm);
		final int color = 0xff424242;
		Paint paint;
		Rect rect;
		Rect cRect;
		RectF rectF;
		for (int i = 0, j = bms.size(); i < j; i++) {
			Bitmap bm = bms.get(i);
			rect = init4Rect(cSize, i);
			if (rect == null)
				break;
			cRect = new Rect(0, 0, bm.getWidth(), bm.getHeight());
			rectF = new RectF(rect);
			paint = new Paint();
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, childRound, childRound, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bm, cRect, rect, paint);
		}
		return pBm;
	}

	
	
	private static Bitmap drawable3Bitmap(ArrayList<Bitmap> bms, int size,
			int childRound) {
		int cSize = (size - 3* space) / 2;
		Bitmap pBm = Bitmap.createBitmap(size, size, Config.ARGB_8888);
		Canvas canvas = new Canvas(pBm);
		final int color = 0xff424242;
		Paint paint;
		Rect rect;
		Rect cRect;
		RectF rectF;
		for (int i = 0, j = bms.size(); i < j; i++) {
			Bitmap bm = bms.get(i);
			rect = init3Rect(cSize, i);
			if (rect == null)
				break;
			cRect = new Rect(init3Rect(bm.getWidth(), bm.getHeight(), i));
			rectF = new RectF(rect);
			paint = new Paint();
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, childRound, childRound, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bm, cRect, rect, paint);
		}
		return pBm;
	}
	
	
	
	private static Bitmap drawable2Bitmap(ArrayList<Bitmap> bms, int size,
			int childRound) {
		int cSize = (size - 2*space)/2 ;
		Bitmap pBm = Bitmap.createBitmap(size, size, Config.ARGB_8888);
		Canvas canvas = new Canvas(pBm);
		final int color = 0xff424242;
		Paint paint;
		Rect rect;
		Rect cRect;
		RectF rectF;
		for (int i = 0, j = bms.size(); i < j; i++) {
			Bitmap bm = bms.get(i);
			rect = init2Rect(cSize, i);
			if (rect == null)
				break;
			cRect = new Rect(init2Rect(bm.getWidth(), bm.getHeight(), i));
			rectF = new RectF(rect);
			paint = new Paint();
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, childRound, childRound, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bm, cRect, rect, paint);
		}
		return pBm;
	}
	
	
	public static Bitmap drawable9Bitmap(ArrayList<Bitmap> bms, int size,
			int childRound) {
		int cSize = (size - 4 * space) / 3;
		Bitmap pBm = Bitmap.createBitmap(size, size, Config.ARGB_8888);
		Canvas canvas = new Canvas(pBm);
		final int color = 0xff424242;
		Paint paint;
		Rect rect;
		Rect cRect;
		RectF rectF;
		for (int i = 0, j = bms.size(); i < j; i++) {
			Bitmap bm = bms.get(i);
			rect = init9Rect(cSize, i);
			if (rect == null)
				break;
			cRect = new Rect(0, 0, bm.getWidth(), bm.getHeight());
			rectF = new RectF(rect);
			paint = new Paint();
			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
			paint.setColor(color);
			canvas.drawRoundRect(rectF, childRound, childRound, paint);
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bm, cRect, rect, paint);
		}
		return pBm;
	}

	private static Rect init4Rect(int size, int index) {
		switch (index) {
		case 0:
			return new Rect(space, space, space + size, space + size);
		case 1:
			return new Rect(2 * space + size, space, 2 * (space + size), space
					+ size);
		case 2:
			return new Rect(space, 2 * space + size, space + size,
					2 * (space + size));
		case 3:
			return new Rect(2 * space + size, 2 * space + size,
					2 * (space + size), 2 * (space + size));
		default:
			return null;
		}
	}
	
	
	private static Rect init2Rect(int size, int index) {
		switch (index) {
		case 0:
			return new Rect(space, space, (space+size), 2*(space + size));
		case 1:
			return new Rect(space+size, space, 2*(space+size), 2*(space+size));
		
		default:
			return null;
		}
	}
	
	
	
	private static Rect init2Rect(int width, int height,int index) {
		switch (index) {
		case 0:
			return new Rect(width/4, 0, 3*(width/4), height);
		case 1:
			return new Rect(width/4, 0, 3*(width/4), height);
		
		default:
			return null;
		}
	}
	
	
	
	private static Rect init3Rect(int size, int index) {
		switch (index) {
		case 0:
			return new Rect(space, space, space+size, 2*(space+size));
		case 1:
			return new Rect(2*space+size, space, 2 * (space + size), space+size);
		case 2:
			return new  Rect(2 * space + size, 2 * space + size,
					2 * (space + size), 2 * (space + size));
		default:
			return null;
		}
	}
	
	
	private static Rect init3Rect(int width, int height,int index) {
		switch (index) {
		case 0:
			return new Rect(width/4, 0, 3*(width/4), height);
		case 1:
			return new Rect(0, 0,width, height);
		case 2:
			return new Rect(0, 0,width, height);
		default:
			return null;
		}
	}
	
	
	

	private static Rect init9Rect(int size, int index) {
		switch (index) {
		case 0:
			return new Rect(space, space, space + size, space + size);
		case 1:
			return new Rect(2 * space + size, space, 2 * (space + size), space
					+ size);
		case 2:
			return new Rect(3 * space + 2 * size, space, 3 * (space + size),
					space + size);
		case 3:
			return new Rect(space, space + size, space + size,
					2 * (space + size));
		case 4:
			return new Rect(2 * space + size, 2 * space + size,
					2 * (space + size), 2 * (space + size));
		case 5:
			return new Rect(3 * space + 2 * size, 2 * space + size,
					3 * (space + size), 2 * (space + size));
		case 6:
			return new Rect(space, 3 * space + 2 * size, space + size,
					3 * (space + size));
		case 7:
			return new Rect(2 * space + size, 3 * space + 2 * size,
					2 * (space + size), 3 * (space + size));
		case 8:
			return new Rect(3 * space + 2 * size, 3 * space + 2 * size,
					3 * (space + size), 3 * (space + size));
		default:
			return null;
		}
	}

	/**
	 * 图片圆角
	 * 
	 * @param bitmap
	 * @return
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);
		final float roundPx = 12;
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

}
