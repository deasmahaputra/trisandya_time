package alrithm.deastudio.trisandya_time.fragment;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;

import alrithm.deastudio.trisandya_time.Alarm.MyReceiver;
import info.androidhive.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlarmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlarmFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private PendingIntent pendingIntent;
    private TextView textViewEnamPagi, textViewDuabelas, textViewenamSore;
    private ToggleButton toggleButtonEnamPagi, toggleButtonDuaBelas, toggleButtonEnamSore;

    public AlarmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlarmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlarmFragment newInstance(String param1, String param2) {
        AlarmFragment fragment = new AlarmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);
        toggleButtonEnamPagi = (ToggleButton) v.findViewById(R.id.toggleButton);
        //textViewDuabelas = (ToggleButton) getActivity().findViewById(R.id.toggleButton2);
        textViewEnamPagi = (TextView)   v.findViewById(R.id.textViewalarm);
        textViewDuabelas = (TextView) v.findViewById(R.id.textView);
        toggleButtonDuaBelas = (ToggleButton) v.findViewById(R.id.toggleButton2);

        textViewEnamPagi.setText("OFF Pukul 06.00 AM");
        textViewDuabelas.setText("OFF Pukul 12.00 PM");

        toggleButtonEnamPagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtonEnamPagi.isChecked()){
                    textViewEnamPagi.setText("ON Pukul 06.00 AM");
                    SharedPreferences preferences = getActivity().getPreferences(0);
                    SharedPreferences.Editor edt = preferences.edit();
                    edt.putBoolean("tgEnam", true);
                    edt.commit();
                }else {
                    textViewEnamPagi.setText("OFF Pukul 06.00 AM");
                    SharedPreferences preferences = getActivity().getPreferences(0);
                    SharedPreferences.Editor edt = preferences.edit();
                    edt.putBoolean("tgEnam", false);
                    edt.commit();
                }
            }
        });

        toggleButtonDuaBelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButtonDuaBelas.isChecked()){
                    textViewDuabelas.setText("ON Pukul 12.00 PM");
                    SharedPreferences preferences = getActivity().getPreferences(0);
                    SharedPreferences.Editor edt = preferences.edit();
                    edt.putBoolean("tgDuabelas", true);
                    edt.commit();
                }else{
                    textViewDuabelas.setText("OFF Pukul 12.00 PM");
                    SharedPreferences preferences = getActivity().getPreferences(0);
                    SharedPreferences.Editor edt = preferences.edit();
                    edt.putBoolean("tgDuabelas", false);
                    edt.commit();
                }
            }
        });


        startSix();
        startDuaBelas();
        // Inflate the layout for this fragment
    return v;
    }
    public void startSix(){
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean tgenam = preferences.getBoolean("tgEnam", true);
        if(tgenam = true){
            textViewEnamPagi.setText("ON Pukul 06.00 AM");
            toggleButtonEnamPagi.setChecked(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 6);
            calendar.set(Calendar.MINUTE,0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.AM_PM,Calendar.AM);

            Intent myIntent = new Intent(getActivity().getApplication(), MyReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(getActivity().getApplication(), 0, myIntent,0);

            AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        }else{

        }

    }
    public  void startDuaBelas(){
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean tgduabelas = preferences.getBoolean("tgDuabelas", true);
        if(tgduabelas = true){
            textViewDuabelas.setText("ON Pukul 12.00 PM");
            toggleButtonDuaBelas.setChecked(true);
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 8);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.AM_PM,Calendar.AM);

            Intent myIntent = new Intent(getActivity().getApplication(), MyReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(getActivity().getApplication(), 0, myIntent,0);

            AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
        }else{
            textViewDuabelas.setText("OFF Pukul 12.00 PM");

        }
    }

}
