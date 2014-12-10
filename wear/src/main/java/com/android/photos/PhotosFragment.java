package com.android.photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PhotosFragment extends Fragment {

  private static final String PHOTO_MODEL = "com.android.photos.photo_model";

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_photo, container, false);
    PhotosModel photosModel = getArguments().getParcelable(PhotosFragment.PHOTO_MODEL);
    ((TextView) view.findViewById(R.id.title)).setText(photosModel.getTitle());
    view.setBackgroundResource(photosModel.getDrawableId());
    return view;
  }

  public static Fragment newInstance(PhotosModel photosModel) {
    PhotosFragment photosFragment = new PhotosFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(PhotosFragment.PHOTO_MODEL, photosModel);
    photosFragment.setArguments(bundle);
    return photosFragment;
  }
}
