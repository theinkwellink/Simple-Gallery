package com.simplemobiletools.gallery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import com.simplemobiletools.gallery.activities.ViewPagerActivity;

public class ViewPagerFragment extends Fragment implements View.OnClickListener {
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.pager_item, container, false);

        if (path != null) {
            final SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) view.findViewById(R.id.photo);
            imageView.setImage(ImageSource.uri(path));
            imageView.setMaxScale(5f);
            imageView.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        ((ViewPagerActivity) getActivity()).photoClicked();
    }
}