package org.itheima56.googleplay.holder;

import java.util.List;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.utils.BitmapHelper;
import org.itheima56.googleplay.utils.Constans;
import org.itheima56.googleplay.utils.UIUtils;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: HomePictureHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 上午9:13:25
 * @描述: 轮播图的holder
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomePictureHolder extends BaseHolder<List<String>>
{
	@ViewInject(R.id.item_home_picture_pager)
	private ViewPager		mPager;

	@ViewInject(R.id.item_home_picture_container_indicator)
	private LinearLayout	mPointContainer;

	private List<String>	mPictures;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_home_picture, null);

		// 注入
		ViewUtils.inject(this, view);

		return view;
	}

	@Override
	protected void refreshUI(List<String> data)
	{
		this.mPictures = data;

		// 给viewpager设置adapter-->list
		mPager.setAdapter(new HomePictureAdapter());
	}

	class HomePictureAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			if (mPictures != null) { return mPictures.size(); }
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object)
		{
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			ImageView iv = new ImageView(UIUtils.getContext());
			iv.setScaleType(ScaleType.FIT_XY);
			// 给iv设置数据
			iv.setImageResource(R.drawable.ic_default);// 设置默认图片
			// 设置网络图片
			BitmapHelper.display(iv, Constans.IMAGE_BASE_URL + mPictures.get(position));

			// 给viewpager加视图
			container.addView(iv);

			return iv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View) object);
		}

	}

}
