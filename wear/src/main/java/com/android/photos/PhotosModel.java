package com.android.photos;

import android.os.Parcel;
import android.os.Parcelable;

public class PhotosModel implements Parcelable{

  private String title;
  private int drawableId;

  public PhotosModel(String title, int drawableId) {
    this.title = title;
    this.drawableId = drawableId;
  }

  public PhotosModel(Parcel in) {
    title = in.readString();
    drawableId = in.readInt();
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeInt(drawableId);
  }

  public static final Creator<PhotosModel> CREATOR = new Creator<PhotosModel>() {

    @Override
    public PhotosModel createFromParcel(Parcel in) {
      return new PhotosModel(in);
    }

    @Override
    public PhotosModel[] newArray(int size) {
      return new PhotosModel[size];
    }

  };

  public String getTitle() {
    return title;
  }

  public int getDrawableId() {
    return drawableId;
  }
}
