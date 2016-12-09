package alrithm.deastudio.trisandya_time.Alarm;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;

import alrithm.deastudio.trisandya_time.activity.MainActivity;
import info.androidhive.navigationdrawer.R;

/**
 * Created by DEAS on 27/11/2016.
 */
public class MyAlarmService extends Service{
    NotificationManager manager;
    Notification myNotication;
    private NotificationManager mManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);

//        Notification notification = new Notification(R.drawable.omnew,"This is a test message!", System.currentTimeMillis());
//        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
        PendingIntent pendingIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_CANCEL_CURRENT);
        //myNotication.flags |= Notification.FLAG_AUTO_CANCEL;
//        notification.setLatestEventInfo(this.getApplicationContext(), "AlarmManagerDemo", "This is a test message!", pendingNotificationIntent);

        Notification.Builder builder = new Notification.Builder(MyAlarmService.this);

        builder.getNotification().flags = Notification.FLAG_AUTO_CANCEL;
        builder.setAutoCancel(true);
        builder.setTicker("this is ticker text");
        builder.setContentTitle("Trisandya Time");
        builder.setContentText("Om Swastyastu");
        builder.setSmallIcon(R.drawable.omnew);
        builder.setContentIntent(pendingIntent);
        //builder.setOngoing(true);
        builder.setSubText("Time to pray");   //API level 16
        builder.setNumber(1);
        builder.build();
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.puja);
        builder.setSound(uri);

        myNotication = builder.getNotification();

        manager.notify(0, myNotication);
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}
