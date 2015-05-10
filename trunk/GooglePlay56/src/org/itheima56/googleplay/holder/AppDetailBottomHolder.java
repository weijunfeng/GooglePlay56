package org.itheima56.googleplay.holder;

import org.itheima56.googleplay.R;
import org.itheima56.googleplay.bean.AppInfoBean;
import org.itheima56.googleplay.bean.DownloadInfo;
import org.itheima56.googleplay.manager.DownloadManager;
import org.itheima56.googleplay.utils.UIUtils;
import org.itheima56.googleplay.widget.ProgressButton;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.view.View.OnClickListener;

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
public class AppDetailBottomHolder extends BaseHolder<AppInfoBean> implements OnClickListener
{

	@ViewInject(R.id.app_detail_download_btn_download)
	private ProgressButton	mProgressButton;

	@Override
	protected View initView()
	{
		View view = View.inflate(UIUtils.getContext(), R.layout.item_app_detail_bottom, null);

		// 注入
		ViewUtils.inject(this, view);

		// 设置点击事件
		mProgressButton.setOnClickListener(this);

		return view;
	}

	@Override
	protected void refreshUI(AppInfoBean data)
	{
		// 给用户提示 TODO:

		DownloadInfo info = DownloadManager.getInstance().getDownloadInfo(data);

		// 根据下载信息的状态来给用户提示 TODO:

	}

	@Override
	public void onClick(View v)
	{
		if (v == mProgressButton)
		{
			clickProgressButton();
		}
	}

	// 点击的操作
	private void clickProgressButton()
	{

		// 行为逻辑操作 TODO:
		doDownload();
	}

	// 下载
	private void doDownload()
	{
		DownloadManager.getInstance().download(mData);
	}

}
