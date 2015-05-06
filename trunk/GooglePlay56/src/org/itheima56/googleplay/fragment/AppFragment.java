package org.itheima56.googleplay.fragment;

import java.util.List;

import org.itheima56.googleplay.R.color;
import org.itheima56.googleplay.adapter.SuperBaseAdapter;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.fragment.HomeFragment.HomeAdapter;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.AppItemHolder;
import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.http.AppProtocol;
import org.itheima56.googleplay.utils.UIUtils;

import android.graphics.Color;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.fragment
 * @类名: AppFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 下午4:57:26
 * @描述: 应用的页面
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppFragment extends BaseFragment
{
	private List<AppInfoBean>	mDatas;
	private AppProtocol			mProtocol;

	@Override
	protected View onLoadSuccessView()
	{
		ListView listView = new ListView(UIUtils.getContext());

		// 属性设置
		listView.setCacheColorHint(Color.TRANSPARENT);
		listView.setSelector(android.R.color.transparent);
		listView.setDividerHeight(0);
		listView.setScrollingCacheEnabled(false);
		listView.setBackgroundColor(UIUtils.getColor(color.bg));

		// 设置数据 -->adapter ---> list
		listView.setAdapter(new AppAdapter(listView, mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		mProtocol = new AppProtocol();

		try
		{
			mDatas = mProtocol.loadData(0);
			return checkData(mDatas);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return LoadedResult.ERROR;
		}
	}

	class AppAdapter extends SuperBaseAdapter<AppInfoBean>
	{

		public AppAdapter(AbsListView listView, List<AppInfoBean> datas) {
			super(listView, datas);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected BaseHolder<AppInfoBean> getItemHolder()
		{
			return new AppItemHolder();
		}

		@Override
		protected List<AppInfoBean> onLoadMoreData() throws Exception
		{
			return mProtocol.loadData(mDatas.size());
		}

	}

}
