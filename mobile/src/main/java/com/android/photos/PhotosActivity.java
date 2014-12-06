package com.android.photos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.ArrayList;


public class PhotosActivity extends FragmentActivity {

  public static final String PHOTOS_TITLE = "title";
  private GoogleApiClient mGoogleApiClient;
  private ArrayList<PhotosModel> photosModels;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photos);
    photosModels = new ArrayList<PhotosModel>(){{
      add(new PhotosModel("Rajnikant First", R.drawable.rajnikant_first));
      add(new PhotosModel("Rajnikant Second", R.drawable.rajnikant_2));
    }};

    mGoogleApiClient = new GoogleApiClient.Builder(this)
        .addApi(Wearable.API)
        .build();
    mGoogleApiClient.connect();

    ViewPager gallery = (ViewPager) findViewById(R.id.gallery);
    gallery.setAdapter(new PhotosAdapter(getSupportFragmentManager(), photosModels));
    gallery.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i2) {

      }

      @Override
      public void onPageSelected(int i) {
        showNotification(i);
      }

      @Override
      public void onPageScrollStateChanged(int i) {

      }
    });
  }

  private void showNotification(int index) {
    PutDataMapRequest putDataMapRequest = PutDataMapRequest.create("/index");

    DataMap map = putDataMapRequest.getDataMap();
    map.putString(PHOTOS_TITLE, photosModels.get(index).getTitle());

    Wearable.DataApi.putDataItem(mGoogleApiClient, putDataMapRequest.asPutDataRequest());
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.photos, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
