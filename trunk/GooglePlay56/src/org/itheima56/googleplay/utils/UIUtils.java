package org.itheima56.googleplay.utils;

import org.itheima56.googleplay.BaseApplication;

import android.content.Context;
import android.content.res.Resources;
import android.widget.BaseAdapter;

/**
 * @项目名: GooglePlay56
 * @包名: org.itheima56.googleplay.utils
 * @类名: UIUtils
 * @创建者: 肖琦
 * @创建时间: 2015-5-4 上午10:26:29
 * @描述: 提供UI操作的工具类
 * 
 * @svn版本: $Rev$
 * @更新人: $Author$
 * @更新时间: $Date$
 * @更新描述: TODO
 */
public class UIUtils
{
	/**
	 * 上下文
	 * 
	 * @return
	 */
	public static Context getContext()
	{
		return BaseApplication.getContext();
	}

	public static Resources getResources()
	{
		return getContext().getResources();
	}

	public static String getString(int resId)
	{
		return getResources().getString(resId);
	}

	public static String[] getStringArray(int resId)
	{
		return getResources().getStringArray(resId);
	}

	public static String getPackageName()
	{
		return getContext().getPackageName();
	}

	public static int getColor(int resId)
	{
		return getResources().getColor(resId);
	}
}
