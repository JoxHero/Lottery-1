package axhome.com.threesell;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.fe.library.TabContainerView;
import com.fe.library.adapter.DefaultAdapter;

import axhome.com.threesell.fragment.ContactsFragment;
import axhome.com.threesell.fragment.HomePageFragment;
import axhome.com.threesell.fragment.MyFragment;
import axhome.com.threesell.fragment.OrderFragment;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {


    private TabContainerView tabContainerView;
    private int[] iconImageArray, selectedIconImageArray;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ///
    }

    private void initView() {
        iconImageArray = new int[]{R.drawable.homepage, R.drawable.contacts, R.drawable.order, R.drawable.my};
        selectedIconImageArray = new int[]{R.drawable.homepagegreen, R.drawable.contactsgreen, R.drawable.ordergreen, R.drawable.mygreen};
        fragments = new Fragment[]{new HomePageFragment(), new ContactsFragment(), new OrderFragment(), new MyFragment()};

        tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
        tabContainerView.setTabHostBgColor(Color.parseColor("#F2F2F2"));
        tabContainerView.setAdapter(new DefaultAdapter(this, fragments, getSupportFragmentManager(), getResources().getStringArray(R.array.titleArray),
                getResources().getColor(R.color.colorPrimary), iconImageArray, selectedIconImageArray));
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }
}
