package com.android.photos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PhotosAdapter extends FragmentPagerAdapter {

  ArrayList<PhotosModel> photosModels;
  public PhotosAdapter(FragmentManager fm, ArrayList<PhotosModel> photosModels) {
    super(fm);
    this.photosModels = photosModels;
  }

  @Override
  public Fragment getItem(int index) {
    return PhotosFragment.newInstance(photosModels.get(index));
  }

  @Override
  public int getCount() {
    return photosModels.size();
  }
}
