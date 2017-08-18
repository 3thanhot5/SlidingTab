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


public class OfficeFragment extends BaseFragment {

    private static final String DATA_NAME = "name";
    private String[] mtitle = new String[]{"0", "1","2","3","4", "5", "6", "7", "8", "9", "10", "11", "12"} ;
    private String[] minfo =  new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
    private String title = "";

    public static OfficeFragment newInstance(String title, int indicatorColor,
                                           int dividerColor, int iconResId) {

        DLog.d("OfficeFragment - newInstance");
        OfficeFragment f = new OfficeFragment();
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
        DLog.d("OfficeFragment - onActivityCreated");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DLog.d("OfficeFragment - onCreate");

        //get data
        title = getArguments().getString(DATA_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        DLog.d("OfficeFragment - onDestroy");
        super.onDestroy();
    }



    @Override
    public void onDestroyView() {
        DLog.d("OfficeFragment - onDestroyView");
        super.onDestroyView();
    }



}
