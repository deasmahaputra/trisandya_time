package alrithm.deastudio.trisandya_time.Doa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import alrithm.deastudio.trisandya_time.Doa.Details.DoaListSeharihariView;
import info.androidhive.navigationdrawer.R;

public class DoaListSeharihari extends AppCompatActivity {

    ListView listView;
    final String[] namadoa = {"Doa Bangun Pagi", "Doa Memulai Pekerjaan", "Doa Mencuci Muka", "Doa Sebelum Makan", "Doa Sebelum Tidur"};
    final Integer[] imgid = {R.drawable.hinduism,R.drawable.hinduism,R.drawable.hinduism,R.drawable.hinduism,R.drawable.hinduism};
    final String[] isidoa = {"Om Swastyastu","Om Swastyastu","Om Swastyastu","Om Swastyastu","Om Swastyastu"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CustomListAdapter listAdapter = new CustomListAdapter(this , namadoa, imgid, isidoa);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DoaListSeharihari.this, DoaListSeharihariView.class);
                if(position == 0){
                    intent.putExtra("doaharian","bangunpagi");
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
