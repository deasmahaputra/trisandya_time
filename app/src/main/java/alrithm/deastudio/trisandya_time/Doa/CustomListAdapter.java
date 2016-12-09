package alrithm.deastudio.trisandya_time.Doa;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import info.androidhive.navigationdrawer.R;

/**
 * Created by DEAS on 08/04/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] namadoa;
    private final Integer[] imgid;
    private final String[] isidoa;

    public CustomListAdapter(Activity context, String[] namadoa, Integer[] imgid, String[]isidoa) {
        super(context, R.layout.mylist, namadoa);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.namadoa=namadoa;
        this.imgid=imgid;
        this.isidoa = isidoa;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(namadoa[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(isidoa[position]);
        return rowView;

    };
}
