package itri.vmi.slidingtab.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import itri.vmi.slidingtab.R;
import itri.vmi.slidingtab.listviewAdapter.SearchAdapter;
import itri.vmi.slidingtab.log.DLog;
import itri.vmi.slidingtab.tab.BaseFragment;


public class SearchFragment extends BaseFragment {

    private static final String DATA_NAME = "name";
    private String[] mtitle = new String[]{"0", "1","2","3","4", "5", "6", "7", "8", "9", "10", "11", "12"} ;
    private String[] minfo =  new String[]{"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};
    private String title = "";
    public static SearchFragment newInstance(String title, int indicatorColor, int dividerColor, int iconResId) {
        DLog.d("SearchFragment - newInstance");
        SearchFragment f = new SearchFragment();
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DLog.d("SearchFragment - onCreate");

        //get data
        title = getArguments().getString(DATA_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DLog.d("SearchFragment - onCreateView");
        View view = inflater.inflate(R.layout.frg_common_table, container, false);
        CharSequence[] Mtitle = mtitle;
        CharSequence[] Minfo = minfo;

        EditText SearchText = view.findViewById(R.id.textView);
        /*
        SearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //这个方法被调用，说明在s字符串中，从start位置开始的count个字符即将被长度为after的新文本所取代。在这个方法里面改变s，会报错。
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这个方法被调用，说明在s字符串中，从start位置开始的count个字符刚刚取代了长度为before的旧文本。在这个方法里面改变s，会报错。
            }

            @Override
            public void afterTextChanged(Editable s) {
                //这个方法被调用，那么说明s字符串的某个地方已经被改变。
            }
        });

        */
        ListView lvFrg =view.findViewById(R.id.lvFrgtab);

        SearchAdapter lvAdapter = new SearchAdapter(getActivity(),Mtitle,Minfo);
        lvFrg.setAdapter(lvAdapter);
        lvFrg.setOnItemClickListener(onItemClickListener);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DLog.d("SearchFragment - onViewCreated");
        //TextView txtName = (TextView) view.findViewById(R.id.txtName);
        //txtName.setText(title);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DLog.d("SearchFragment - onActivityCreated");
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
        DLog.d("SearchFragment - onDestroy");
        super.onDestroy();
    }



    @Override
    public void onDestroyView() {
        DLog.d("SearchFragment - onDestroyView");
        super.onDestroyView();
    }



}

