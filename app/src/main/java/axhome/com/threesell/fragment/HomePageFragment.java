package axhome.com.threesell.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;

import java.util.ArrayList;
import java.util.List;

import axhome.com.threesell.R;
import axhome.com.threesell.activity.WebActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {


    @InjectView(R.id.home_convenientBanner)
    ConvenientBanner homeConvenientBanner;
    private List<Integer> imgs = new ArrayList<>();
    private String title;
    private String url;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.inject(this, view);
        initView();
        return view;
    }

    private void initView() {
        //初始化轮播图

        imgs.add(R.drawable.a);
        imgs.add(R.drawable.b);
        imgs.add(R.drawable.c);
        homeConvenientBanner.startTurning(2000);
        homeConvenientBanner.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new LocalImageHolderView();
            }
        }, imgs)
                .setPointViewVisible(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6, R.id.i7, R.id.i8, R.id.iv9, R.id.iv10})
    public void onViewClicked(View view) {
        Intent intent = new Intent(getActivity(), WebActivity.class);
        switch (view.getId()) {
            case R.id.i1:
                title = "双色球";
                url = "http://www.dajiang365.com/mobile/tuijiannew.html?authtoken=";
                break;
            case R.id.i2:
                title = "竞彩篮球";
                url = "http://mlive.159cai.com/live/basketball?from=159cai";
                break;
            case R.id.i3:
                title = "大乐透";
                url = "http://news.zhuoyicp.com/h5/zj/a/content_45923.shtml?%22";
                break;
            case R.id.i4:
                title = "竞彩足球";
                url = "http://www.dajiang365.com/mobile/tuijiannew.html?authtoken=";
                break;
            case R.id.i5:
                title = "福彩3D";
                url = "http://m.159cai.com/news/new170612.html";
                break;
            case R.id.i6:
                title = "排5";
                url = "http://www.dajiang365.com/MobileActivity/kl3miji.html?authtoken=";
                break;
            case R.id.i7:
                title = "排3";
                url = "http://client.310win.com/aspx/RecommendExpert.aspx?id=3103504";
                break;
            case R.id.i8:
                title = "更多";
                url = "http://m.jdd.com/common/news/detail.html?id=100037287";
                break;
            case R.id.iv9:
                url = "http://live.159cai.com/live/jingcai?from=159cai";
                break;
            case R.id.iv10:
                url = "http://www.dajiang365.com/MobileActivity/kl3miji.html?authtoken=";
                break;
        }
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    public class LocalImageHolderView implements Holder<Integer> {

        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, Integer data) {
            imageView.setImageResource(data);
        }
    }
}
