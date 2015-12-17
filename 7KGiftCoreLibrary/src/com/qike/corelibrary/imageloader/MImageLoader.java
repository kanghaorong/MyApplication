package com.qike.corelibrary.imageloader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.ls.LSException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.qike.corelibrary.utils.FileUtils;

/**
 * 
 *<p>对开源Imageloader的扩展和封装</p><br/>
 * @since 1.0.0
 * @author xky
 */
public class MImageLoader {
	private static MImageLoader INSTANCE = null;
	public static  List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());
	private Context mContext;
	private MImageLoader(Context context){
		mContext = context;
	}
	public synchronized static MImageLoader getInstance(Context context){
		if(INSTANCE == null){
			INSTANCE = new MImageLoader(context);
		}
		return INSTANCE;
	}
	/**
	 * 
	 *<p>初始化图片加载器</p><br/>
	 * @since 1.0.0
	 * @author xky
	 */
	public void initImageLoader(Context context){
//		ImageLoaderConfiguration conf = ImageLoaderConfiguration.createDefault(context);
		ImageLoaderConfiguration conf = new ImageLoaderConfiguration.Builder(context)
		.threadPriority(Thread.NORM_PRIORITY - 2)//设置线程的优先级
		.denyCacheImageMultipleSizesInMemory()//当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
		.discCacheFileNameGenerator(new Md5FileNameGenerator())//设置缓存文件的名字
		.discCacheFileCount(100)//缓存文件的最大个数
		.tasksProcessingOrder(QueueProcessingType.LIFO)// 设置图片下载和显示的工作队列排序
		.build();
		ImageLoader.getInstance().init(conf);
	}
	
	/**
	 * 
	 *<p>展示一个普通图片</p><br/>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 */
	public void displayImage(String uri,ImageView imageView){
		ImageLoader.getInstance().displayImage(uri, imageView);
	}
	

	
	/**
	 * 
	 *<p>展示一个有默认图片和圆角的图片</p><br/>
	 *<p>展示过程中并没有动画</p>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 * @param defaultImgId 默认图片id
	 * @param round 圆角度数，越大越园
	 */
	public void displayImage(String uri,ImageView imageView,int defaultImgId,int round){
		Builder builder = new DisplayImageOptions.Builder().showStubImage(defaultImgId).showImageForEmptyUri(defaultImgId)
		.showImageOnFail(defaultImgId).cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(round));
		ImageLoader.getInstance().displayImage(operateImgUrl(uri), imageView,builder.build());
	}
	
	/**
	 * 
	 *<p>展示一个有默认图片和圆角的图片</p><br/>
	 *<p>展示过程中并没有动画</p>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 * @param defaultImgId 默认图片id
	 * @param round 圆角度数，越大越园
	 */
	public void displayImage1(String uri,ImageView imageView,int defaultImgId,int round){
		Builder builder = new DisplayImageOptions.Builder().showStubImage(defaultImgId).showImageForEmptyUri(defaultImgId)
		.showImageOnFail(defaultImgId).cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(round));
		ImageLoader.getInstance().displayImage(uri, imageView,builder.build());
	}
	/**
	 * 
	 *<p>有过度动画的展示图片</p><br/>
	 *<p>没有默认图片，没有圆角设置</p>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 * @param listener
	 */
	public void displayImage(String uri,ImageView imageView,ImageLoadingListener listener){
		if(listener == null){
			listener = mLoadImageListener;
		}
		ImageLoader.getInstance().displayImage(uri, imageView,listener);
	}
	/**
	 * 
	 *<p>有过度动画的展示图片</p><br/>
	 *<p>没有默认图片，没有圆角设置</p>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 * @param listener
	 */
	public void displayImage2(String uri,ImageView imageView,SimpleImageLoadingListener listener,int width){
		if(listener == null){
			listener = mLoadImageListener;
		}
		DisplayImageOptions options = new DisplayImageOptions.Builder().imageScaleType(ImageScaleType.EXACTLY_STRETCHED).build();
//		ImageLoader.getInstance().displayImage(operateImgUrl2(uri,width), imageView,listener);
		ImageLoader.getInstance().displayImage(operateImgUrl2(uri,width), imageView, options);
	}
	/**
	 * 
	 *<p>既有默认动画，又有默认图片，又有圆角大小来展示图片</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param uri
	 * @param imageView
	 * @param listener
	 * @param defaultImgId
	 * @param round
	 */
	public void displayImage(String uri,ImageView imageView,SimpleImageLoadingListener listener,int defaultImgId,int round){
		Builder builder = new DisplayImageOptions.Builder().showStubImage(defaultImgId).showImageForEmptyUri(defaultImgId)
				.showImageOnFail(defaultImgId).cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(round));
		if(listener == null){
			listener = mLoadImageListener;
		}
		ImageLoader.getInstance().displayImage(operateImgUrl(uri), imageView, builder.build() );
	}
	private SimpleImageLoadingListener mLoadImageListener =  new SimpleImageLoadingListener(){
		@Override
		public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
			super.onLoadingComplete(imageUri, view, loadedImage);
		}
	};
	
	/**
	 *<p>图片根据分辨率进行请求</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param url
	 * @return
	 */
	public String operateImgUrl(String url){
		float density = FileUtils.getDensity(mContext);
		if(url.endsWith(".jpg") || url.endsWith(".png") ){
			return url;
		}
		if(density >1.5 && density<=2){
			//大分辨率
			return url+"_144-144.jpg";
		}else if(density == 1.5){
			//中分辨率
			return url+"_98-98.jpg";
		}else if(density == 1){
			//小分辨率
			return url+"_65-65.jpg";
		}else{
			return url+".jpg";
		}
//		return url+".jpg";
	}
	/**
	 * 
	 *<p>根据屏幕的宽度加载图片</p><br/>
	 *<p>TODO(详细描述)</p>
	 * @since 1.0.0
	 * @author xky
	 * @param url
	 * @return
	 */
	public String operateImgUrl2(String url,int width){
	
		if(url.endsWith(".jpg") || url.endsWith(".png") ){
			return url;
		}
		if(width >480){
			//大分辨率
			return url+"_600-230.jpg";
		}else{
			return url+"_600-260.jpg";
		}
	}
}
