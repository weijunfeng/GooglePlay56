package org.itheima56.googleplay.fragment;

import java.util.ArrayList;
import java.util.List;

import org.itheima56.googleplay.adapter.SuperBaseAdapter;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.HomeBean;
import org.itheima56.googleplay.fragment.LoadingPager.LoadedResult;
import org.itheima56.googleplay.holder.AppItemHolder;
import org.itheima56.googleplay.holder.BaseHolder;
import org.itheima56.googleplay.utils.UIUtils;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

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
	// private List<String> mDatas; // 假数据,数据模拟
	private List<AppInfoBean>	mDatas;	// listView对应的数据
	private List<String>		mPictures;	// 轮播图对应的数据

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

	// 此方法实在子线程中执行的
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

		// // ## 2.模拟假数据
		// mDatas = new ArrayList<String>();
		//
		// for (int i = 0; i < 50; i++)
		// {
		// mDatas.add(i + "");
		// }
		// return LoadedResult.SUCCESS;

		// ## 3.去网络加载数据

		try
		{
			HttpUtils utils = new HttpUtils();
			// method,url,header,params
			String url = "http://10.0.2.2:8080/GooglePlayServer/home";
			RequestParams params = new RequestParams();

			params.addQueryStringParameter("index", 0 + "");
			ResponseStream stream = utils.sendSync(HttpMethod.GET, url, params);

			// 响应码
			int statusCode = stream.getStatusCode();
			if (200 == statusCode)
			{
				// 访问接口成功
				// 获取json字符
				String json = stream.readString();
				// 解析json字符
				Gson gson = new Gson();
				HomeBean bean = gson.fromJson(json, HomeBean.class);

				// 判断bean是否为空
				LoadedResult result = checkData(bean);
				if (result != LoadedResult.SUCCESS) { return result; }

				result = checkData(bean.list);
				if (result != LoadedResult.SUCCESS) { return result; }

				mDatas = bean.list;
				mPictures = bean.picture;

				return result;
			}
			else
			{
				// 访问接口失败

				return LoadedResult.ERROR;
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
			// 联网失败
			return LoadedResult.ERROR;
		}

	}

	class HomeAdapter extends SuperBaseAdapter<AppInfoBean>
	{

		public HomeAdapter(List<AppInfoBean> datas) {
			super(datas);
		}

		@Override
		protected BaseHolder<AppInfoBean> getItemHolder()
		{
			return new AppItemHolder();
		}
	}

}
