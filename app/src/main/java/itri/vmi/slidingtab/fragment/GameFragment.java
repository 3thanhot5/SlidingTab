package itri.vmi.slidingtab.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import itri.vmi.slidingtab.R;
import itri.vmi.slidingtab.listviewAdapter.GameAdapter;
import itri.vmi.slidingtab.log.DLog;
import itri.vmi.slidingtab.tab.BaseFragment;


public class GameFragment extends BaseFragment {

    private static final String DATA_NAME = "name";
    private String title = "";

    private String[] mtitle = new String[]{"G1","G2","G3","G4", "G5", "G6"} ;
    private String[] minfo =  new String[]{"台北101.故公博物院.中正記念堂","都會公園.高美濕地.大坑風景區","西子灣.英國領事館.愛河","台北101.故公博物院.中正記念堂","都會公園.高美濕地.大坑風景區","西子灣.英國領事館.愛河","台北101.故公博物院.中正記念堂","都會公園.高美濕地.大坑風景區","西子灣.英國領事館.愛河","台北101.故公博物院.中正記念堂","都會公園.高美濕地.大坑風景區","西子灣.英國領事館.愛河","台北101.故公博物院.中正記念堂","都會公園.高美濕地.大坑風景區","西子灣.英國領事館.愛河"};
    public static GameFragment newInstance(String title, int indicatorColor,
                                           int dividerColor, int iconResId) {
        DLog.d("GameFragment - newInstance");
        GameFragment f = new GameFragment();
        f.setTitle(title);
        f.setIndicatorColor(indicatorColor);
        f.setDividerColor(dividerColor);
        //f.setIconResId(iconResId);

        //pass data
        Bundle args = new Bundle();
        args.putString(DATA_NAME, title);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DLog.d("GameFragment - onActivityCreated");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DLog.d("GameFragment - onCreate");

        //get data
        title = getArguments().getString(DATA_NAME);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DLog.d("GameFragment - onCreateView");

        View view = inflater.inflate(R.layout.frg_common, container, false);
        CharSequence[] Mtitle = mtitle;
        CharSequence[] Minfo = minfo;

        ListView lvFrg =view.findViewById(R.id.lvFrg);
        GameAdapter lvAdapter = new GameAdapter(getActivity(),Mtitle,Minfo);
        lvFrg.setAdapter(lvAdapter);

        //	txtName.setText(title);
        lvFrg.setOnItemClickListener(onItemClickListener);
        return view;

    }

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            // TODO Auto-generated method stub
            //do your job here, position is the item position in ListView
            Log.i("TAG", "onListItemClick: " + position);
        }
    };


    @Override
    public void onDestroy() {
        DLog.d("GameFragment - onDestroy");
        super.onDestroy();
    }



    @Override
    public void onDestroyView() {
        DLog.d("GameFragment - onDestroyView");
        super.onDestroyView();
    }



}
