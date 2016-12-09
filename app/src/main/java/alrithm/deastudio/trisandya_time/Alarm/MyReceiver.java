package alrithm.deastudio.trisandya_time.Alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import alrithm.deastudio.trisandya_time.fragment.AlarmFragment;

/**
 * Created by DEAS on 27/11/2016.
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

            Intent service1 = new Intent(context, AlarmFragment.class);
            service1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startService(service1);

            Intent myIntent = new Intent(context, MyAlarmService.class);
            context.startService(myIntent);

    }
}
