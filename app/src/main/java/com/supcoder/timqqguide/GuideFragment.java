package com.supcoder.timqqguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * GuideFragment
 *
 * @author lee
 * @date 2017/10/25
 */

public class GuideFragment extends Fragment {


    private TextView titleTv;
    private TextView subTitleTv;

    private int pos = 0;


    public static GuideFragment getInstance(int pos) {
        GuideFragment fragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("POS", pos);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, container, false);
        titleTv = view.findViewById(R.id.titleTv);
        subTitleTv = view.findViewById(R.id.subTitleTv);

        if (getArguments() != null) {
            pos = getArguments().getInt("POS");
        }

        if (pos >= 0 && pos <= 3) {
            titleTv.setText(getResources().getStringArray(R.array.guide_title_array)[pos]);
            subTitleTv.setText(getResources().getStringArray(R.array.guide_subtitle_array)[pos]);
        }

        return view;
    }
}
