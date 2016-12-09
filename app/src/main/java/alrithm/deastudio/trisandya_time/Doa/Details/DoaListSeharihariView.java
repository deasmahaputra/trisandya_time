package alrithm.deastudio.trisandya_time.Doa.Details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import info.androidhive.navigationdrawer.R;

public class DoaListSeharihariView extends AppCompatActivity {

    private String doaharian = " ";
    private TextView textJudulDoa, textIsiDoa, textArti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doaview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        textJudulDoa = (TextView) findViewById(R.id.textViewJudulDoa);
        textIsiDoa = (TextView) findViewById(R.id.textViewDoa);
        textArti = (TextView) findViewById(R.id.textViewTerjemahan);

        getDataDoa();
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

    public void getDataDoa(){
        Intent intent = getIntent();
        doaharian = intent.getStringExtra("doaharian");

        if(doaharian.equalsIgnoreCase("bangunpagi")){
            textJudulDoa.setText(R.string.doabangunpagijudul);
            textIsiDoa.setText(R.string.doabangunpagi);
            textArti.setText(R.string.artidoabangunpagi);
        }
    }
}
