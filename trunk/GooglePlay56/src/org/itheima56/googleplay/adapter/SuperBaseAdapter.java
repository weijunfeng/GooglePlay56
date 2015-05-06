package org.itheima56.googleplay.adapter;

import java.util.List;

import org.itheima56.googleplay.holder.BaseHolder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.adapter
 * @类名: SuperBaseAdapter
 * @创建者: 肖琦
 * @创建时间: 2015-5-6 上午10:10:42
 * @描述: listView的Adapter的基类
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public abstract class SuperBaseAdapter<T> extends BaseAdapter
{
	private List<T>	mDatas;

	public SuperBaseAdapter(List<T> datas) {
		this.mDatas = datas;
	}

	@Override
	public int getCount()
	{
		if (mDatas != null) { return mDatas.size(); }
		return 0;
	}

	@Override
	public Object getItem(int position)
	{
		if (mDatas != null) { return mDatas.get(position); }
		return null;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		BaseHolder holder = null;

		// ############### 1. 初始化item View #############################
		if (convertView == null)
		{
			// 没有复用
			// 1. 新建holder
			holder = getItemHolder();// 太具体化
			// 2. 加载视图
			// convertView = View.inflate(UIUtils.getContext(),
			// R.layout.item_tmp, null);// 太具体化
			// 通过holder 来提供 视图
			convertView = holder.getRootView();

			// // 3.设置标记
			// convertView.setTag(holder);

			// // 4. 给holder初始化view
			// holder.tv1 = (TextView) convertView.findViewById(R.id.tmp_tv_1);
			// holder.tv2 = (TextView) convertView.findViewById(R.id.tmp_tv_2);
		}
		else
		{
			// 有复用
			holder = (BaseHolder) convertView.getTag();
		}
		// #########################################################

		// ############ 2. 给View设置数据 #############################
		// String data = mDatas.get(position);
		// // 给holder中的view设置数据
		// holder.tv1.setText("头-" + data);
		// holder.tv2.setText("内容-" + data);

		T data = mDatas.get(position);
		// 给holder中的view设置数据
		holder.setData(data);

		// #########################################################

		return convertView;
	}

	protected abstract BaseHolder<T> getItemHolder();
}
