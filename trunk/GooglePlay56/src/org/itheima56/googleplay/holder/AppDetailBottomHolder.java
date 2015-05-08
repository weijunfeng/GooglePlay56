package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.utils.UIUtils;

import android.view.View;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: AppDetailBottomHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-8 下午4:36:49
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class AppDetailBottomHolder extends BaseHolder<AppInfoBean>
{

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_bottom, null);

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{
		// TODO Auto-generated method stub

	}

}
