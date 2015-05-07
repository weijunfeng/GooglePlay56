package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.bean.CategoryBean;
import org.itheima56.googleplay.utils.UIUtils;

import android.view.View;
import android.widget.TextView;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.holder
 * @类名: CategoryItemHolder
 * @创建者: 肖琦
 * @创建时间: 2015-5-7 下午3:42:28
 * @描述: TODO
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class CategoryItemHolder extends BaseHolder<CategoryBean>
{

	private TextView	tv;

	@Override
	protected View initView()
	{
		tv = new TextView(UIUtils.getContext());

		return tv;
	}

	@Override
	protected void refreshUI(CategoryBean data)
	{
		tv.setText(data.name1 + data.name2 + data.name3);
	}

}
