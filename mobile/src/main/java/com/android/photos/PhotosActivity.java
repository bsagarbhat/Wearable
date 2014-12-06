package com.android.photos;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class PhotosActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_photos);
    ArrayList<PhotosModel> photosModels = new ArrayList<PhotosModel>(){{
      add(new PhotosModel("Rajnikant First", R.drawable.rajnikant_first));
      add(new PhotosModel("Rajnikant Second", R.drawable.rajnikant_2));
    }};

    ViewPager gallery = (ViewPager) findViewById(R.id.gallery);
    gallery.setAdapter(new PhotosAdapter(getSupportFragmentManager(), photosModels));
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
