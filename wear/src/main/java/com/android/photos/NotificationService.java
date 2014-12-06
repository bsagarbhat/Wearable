package com.android.photos;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.android.gms.common.data.FreezableUtils;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.ArrayList;

public class NotificationService extends WearableListenerService {
  @Override
  public void onDataChanged(DataEventBuffer dataEvents) {
    ArrayList<DataEvent> events = FreezableUtils.freezeIterable(dataEvents);
    for (DataEvent event : events) {
      if(event.getDataItem().getUri().getPath().equals("/index"))
        showNotification(event);
    }
    super.onDataChanged(dataEvents);
  }

  private void showNotification(DataEvent event) {
    DataMap dataMap = DataMapItem.fromDataItem(event.getDataItem()).getDataMap();
    String id = dataMap.getString("title");

    Intent intent = new Intent(this, getClass());
    PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), 221, intent, PendingIntent.FLAG_UPDATE_CURRENT);

    NotificationManagerCompat manager =
        NotificationManagerCompat.from(getApplicationContext());
    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
    builder.setContentTitle("Gallery")
        .setContentText(String.format("Current Photo title : %s", id))
        .setOngoing(true)
        .setSmallIcon(R.drawable.ic_launcher);
    manager.notify(333, builder.build());
  }
}
