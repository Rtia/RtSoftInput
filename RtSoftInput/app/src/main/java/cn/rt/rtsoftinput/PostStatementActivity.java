/*   
 * Copyright (c) 2010-2020 UCSMY All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */
package cn.rt.rtsoftinput;

/***
 * 账单明细
 */

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import java.util.List;

public class PostStatementActivity extends AppCompatActivity implements OnClickListener {
	/**
	 * 界面控件
	 */
	private ImageView backIv;
	private View shadowView;
	private TextView filterTv, noListTv;
	private LinearLayout filterLayout;
//	private MyListView listView;
//	private PullToRefreshScrollView refreshScrollView;
	private ScrollView scrollView;
	private RelativeLayout noListLayout;
//	private RadioGroup filterRadioGroup;
	private RadioButton filterAllRb, filterRechargeRb, filterWithdrawRb;
	private boolean isPopShowing = false;

	/**
	 * 请求线程参数
	 */
//	private int AccountType = ACCOUNT_TYPE_ALL;
//	private static final int ACCOUNT_TYPE_ALL = 0;
//	private static final int ACCOUNT_TYPE_RECHARGE = 1;
//	private static final int ACCOUNT_TYPE_WITHDRAW = 2;
//
//	private String LastIndex = "";
	private int flag = 1;// 上下拉区分 (1:下拉刷新, 2:上拉加载, 0：无操作)

	// 项目列表adapter
//	private StatementListAdapter adapter;
//	private List<StatementBean> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_statement);
		initView();
		initListener();
	}

	@Override
	public void onResume() {
		super.onResume();
//		StatService.onResume(this);
//
//		AccountType = ACCOUNT_TYPE_ALL;
//		refreshScrollView.setMode(Mode.PULL_FROM_START);
//		filterRadioGroup.check(R.id.filter_all_rb);
//		netWorkHandler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				refreshScrollView.setRefreshing(true);
//			}
//		}, 800);
	}

//	@Override
//	public void onPause() {
//		super.onPause();
//		StatService.onPause(this);
//	}
//
//	@Override
//	protected void onSuccess(Message msg) {
//	}
//
//	@Override
//	protected void onFailure(Message msg) {
//		refreshScrollView.onRefreshComplete();
//		if (msg.obj != null) {
//			ToastUtil.showShortToast(context, msg.obj + "");
//		}
//	}
//
//	@Override
//	protected void onNetworkError(Message msg) {
//		super.onNetworkError(msg);
//		adapter.clear();
//		refreshScrollView.onRefreshComplete();
//		if (msg.obj != null) {
//			ToastUtil.showShortToast(context, msg.obj + "");
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	protected void onDownPull(Message msg) {
//		super.onDownPull(msg);
//		refreshScrollView.onRefreshComplete();
//		if (msg.obj != null) {
//			list = (List<StatementBean>) msg.obj;
//
//			if (list != null && list.size() > 0) {
//				refreshScrollView.setMode(Mode.BOTH);
//				noListLayout.setVisibility(View.GONE);
//				listView.setVisibility(View.VISIBLE);
//				adapter.clear();
//				adapter.appendToList(list);
//
//				scrollView.scrollTo(0, 0);
//			} else {
//				refreshScrollView.setMode(Mode.PULL_FROM_START);
//				noListLayout.setVisibility(View.VISIBLE);
//
//				String noListText = (AccountType == ACCOUNT_TYPE_ALL ?
//						"尚无任何账单记录" :
//						"没有符合您条件的记录，换个条件试试！");
//				noListTv.setText(noListText);
//
//				listView.setVisibility(View.GONE);
//			}
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	protected void onUpPull(Message msg) {
//		super.onUpPull(msg);
//		refreshScrollView.onRefreshComplete();
//		listView.setVisibility(View.VISIBLE);
//
//		list = (List<StatementBean>) msg.obj;
//		if (list != null && list.size() > 0) {
//			adapter.appendToList(list);
//		} else {
//			refreshScrollView.setMode(Mode.PULL_FROM_START);
//		}
//	}
//
//	private void initThread() {
//		PostStatementRequset requset = new PostStatementRequset(application,
//				netWorkHandler, AccountType, LastIndex, flag);
//		requset.getStatementList();
//	}
//
	private void initListener() {
		backIv.setOnClickListener(this);

		filterTv.setOnClickListener(this);
		filterAllRb.setOnClickListener(this);
		filterRechargeRb.setOnClickListener(this);
		filterWithdrawRb.setOnClickListener(this);

		shadowView.setOnClickListener(this);

//		refreshScrollView.setOnRefreshListener(this);
	}

	private void initView() {
		backIv = (ImageView) findViewById(R.id.asset_back_img);

		filterTv = (TextView) findViewById(R.id.filter_tv);
		filterLayout = (LinearLayout) findViewById(R.id.filter_layout);
//		filterRadioGroup = (RadioGroup) findViewById(R.id.filter_rg);
		filterAllRb = (RadioButton) findViewById(R.id.filter_all_rb);
		filterRechargeRb = (RadioButton) findViewById(R.id.filter_recharge_rb);
		filterWithdrawRb = (RadioButton) findViewById(R.id.filter_withdraw_rb);

		shadowView = findViewById(R.id.shadow);

//		listView = (MyListView) findViewById(R.id.listview);
		noListLayout = (RelativeLayout) findViewById(R.id.no_list_layout);
		noListTv = (TextView) findViewById(R.id.no_list_text);
//		refreshScrollView = (PullToRefreshScrollView) findViewById(R.id.refreshScrollView);
//		refreshScrollView.setMode(Mode.BOTH);
//		scrollView = refreshScrollView.getRefreshableView();
//		adapter = new StatementListAdapter(context);
//		listView.setAdapter(adapter);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.asset_back_img:
				finish();
				break;

//			case R.id.shadow:
//				flag = 0;
//				closePop(flag);
//				break;

			case R.id.filter_tv:
				if (isPopShowing){
					flag = 0;
					closePop(flag);
				} else {
					showPop();
				}
				break;

			case R.id.filter_all_rb:
//				AccountType = ACCOUNT_TYPE_ALL;
				flag = 1;
//				refreshScrollView.setMode(Mode.PULL_FROM_START);
				closePop(flag);
				break;

			case R.id.filter_recharge_rb:
//				AccountType = ACCOUNT_TYPE_RECHARGE;
				flag = 1;
//				refreshScrollView.setMode(Mode.PULL_FROM_START);
				closePop(flag);
				break;

			case R.id.filter_withdraw_rb:
//				AccountType = ACCOUNT_TYPE_WITHDRAW;
				flag = 1;
//				refreshScrollView.setMode(Mode.PULL_FROM_START);
				closePop(flag);
				break;

			default:
				break;
		}

	}



//	@Override
//	public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//		flag = 1;
//		LastIndex = "";
//		initThread();
//	}
//
//	@Override
//	public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//		flag = 2;
//		if (adapter.getList() != null && adapter.getList().size() > 0) {
//			LastIndex = adapter.getList().get(adapter.getList().size() - 1).getLastIndex();
//			initThread();
//		} else {
//			refreshView.onRefreshComplete();
//		}
//
//	}

	private void showPop() {
		isPopShowing = true;

		shadowView.setVisibility(View.VISIBLE);
		filterLayout.setVisibility(View.VISIBLE);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.pop_top_open);
//		anim.setAnimationListener(new Animation.AnimationListener() {
//			@Override
//			public void onAnimationStart(Animation animation) {
//			}
//
//			@Override
//			public void onAnimationEnd(Animation animation) {
//				filterLayout.setVisibility(View.VISIBLE);
//			}
//
//			@Override
//			public void onAnimationRepeat(Animation animation) {
//			}
//		});
		filterLayout.startAnimation(anim);

	}

	private void closePop(final int flag) {
		isPopShowing = false;
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.pop_top_close);
		filterLayout.startAnimation(anim);
		anim.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				filterLayout.setVisibility(View.GONE);
				shadowView.setVisibility(View.GONE);

//				if (flag != 0){
//					netWorkHandler.postDelayed(new Runnable() {
//						@Override
//						public void run() {
//							refreshScrollView.setRefreshing(true);
//						}
//					}, 800);
//				}
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && isPopShowing){
			flag = 0;
			closePop(flag);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}