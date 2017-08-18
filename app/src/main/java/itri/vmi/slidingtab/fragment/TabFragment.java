package itri.vmi.slidingtab.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import itri.vmi.slidingtab.R;
import itri.vmi.slidingtab.adapter.TabFragmentPagerAdapter;
import itri.vmi.slidingtab.tab.BaseFragment;
import itri.vmi.slidingtab.tab.SlidingTabLayout;

public class TabFragment extends Fragment {

	private SlidingTabLayout tabs;
	private ViewPager pager;
	private FragmentPagerAdapter adapter;
	
	public static Fragment newInstance(){
		TabFragment f = new TabFragment();
		return f;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frg_tab, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		//adapter
		final LinkedList<BaseFragment> fragments = getFragments();
		adapter = new TabFragmentPagerAdapter(getFragmentManager(), fragments);
		//pager
		pager = (ViewPager) view.findViewById(R.id.pager);
		pager.setAdapter(adapter);
		//tabs
		tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
			
			@Override
			public int getIndicatorColor(int position) {
				return fragments.get(position).getIndicatorColor();
			}
			
			@Override
			public int getDividerColor(int position) {
				return fragments.get(position).getDividerColor();
			}
		});
		tabs.setBackgroundResource(R.color.color_primary);
		tabs.setCustomTabView(R.layout.tab_title, R.id.txtTabTitle, R.id.imgTabIcon);
		tabs.setViewPager(pager);
		
	}
	
	private LinkedList<BaseFragment> getFragments(){
		int indicatorColor = Color.parseColor(this.getResources().getString(R.color.color_accent));
		int dividerColor = Color.TRANSPARENT;
		
		LinkedList<BaseFragment> fragments = new LinkedList<BaseFragment>();
		fragments.add(SearchFragment.newInstance("Search", indicatorColor, dividerColor, android.R.drawable.ic_dialog_info));
		fragments.add(GameFragment.newInstance("Game", indicatorColor, dividerColor, android.R.drawable.ic_dialog_map));
		fragments.add(OfficeFragment.newInstance("Office", indicatorColor, dividerColor, android.R.drawable.ic_dialog_email));

		return fragments;
	}
	
}
