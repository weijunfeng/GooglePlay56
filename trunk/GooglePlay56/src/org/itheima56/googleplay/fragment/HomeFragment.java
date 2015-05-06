package org.itheima56.googleplay.fragment;

import java.util.ArrayList;
import java.util.List;

import org.itheima56.googleplay.adapter.SuperBaseAdapter;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.utils.UIUtils;

import android.view.View;
import android.widget.ListView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay
 * @类名: HomeFragment
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 下午2:51:17
 * @描述: 主页
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class HomeFragment extends BaseFragment
{
	private List<String>	mDatas; // 假数据,数据模拟

	@Override
	protected View onLoadSuccessView()
	{
		// TextView tv = new TextView(UIUtils.getContext());
		// tv.setText("首页");
		// return tv;

		ListView listView = new ListView(UIUtils.getContext());

		// 属性设置
		// listView.setCacheColorHint(Color.TRANSPARENT);
		// listView.setSelector(android.R.color.transparent);
		// listView.setDividerHeight(0);
		// listView.setScrollingCacheEnabled(false);

		// 设置数据 -->adapter ---> list
		listView.setAdapter(new HomeAdapter(mDatas));

		return listView;
	}

	@Override
	protected LoadedResult onLoadingData()
	{
		// ## 1. 随机数的模拟
		// LoadedResult[] results = new LoadedResult[] {
		// LoadedResult.ERROR, LoadedResult.SUCCESS
		// };
		// Random rdm = new Random();
		//
		// try
		// {
		// Thread.sleep(1000);
		// }
		// catch (InterruptedException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return results[rdm.nextInt(results.length)];

		// ## 2.模拟假数据
		mDatas = new ArrayList<String>();

		for (int i = 0; i < 50; i++)
		{
			mDatas.add(i + "");
		}
		return LoadedResult.SUCCESS;
	}

	class HomeAdapter extends SuperBaseAdapter<String>
	{

		public HomeAdapter(List<String> datas) {
			super(datas);
		}

		
	}

}
