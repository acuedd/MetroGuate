package acuedd.com.gt.metroguate;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import acuedd.com.gt.metroguate.utils.itemStops;

public class ScrollingActivity extends AppCompatActivity {

    private Spinner SpinnerFrom;
    private Spinner SpinnerTo;
    private ArrayAdapter<String> aBusStops;
    private ListView ListBus;
    private LinearLayout LayoutList;
    private LinearLayout layoutInitial,ll_searchNew;
    private LinearLayout layoutSearch;
    private ArrayAdapter<itemStops> adapter;

    private RelativeLayout rl_ubicacion,rl_destino,rl_buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context actvitiyContext = this.getApplicationContext();

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SpinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        SpinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        ListBus = (ListView) findViewById(R.id.ListBus);
        LayoutList = (LinearLayout) findViewById(R.id.layoutList);
        layoutInitial = (LinearLayout) findViewById(R.id.layoutInitial);
        layoutSearch = (LinearLayout) findViewById(R.id.layoutSearch);
        ll_searchNew = (LinearLayout) findViewById(R.id.ll_searchNew);

        rl_ubicacion = (RelativeLayout) findViewById(R.id.rl_ubicacion);
        rl_destino = (RelativeLayout) findViewById(R.id.rl_destino);
        rl_buttons = (RelativeLayout) findViewById(R.id.rl_buttons);

        int limit = 8;
        String[] spinnerStops = new String[limit];
        spinnerStops[0] = "Mixco Parque";
        spinnerStops[1] = "Molino las flores";
        spinnerStops[2] = "Escala Roosvelth";
        spinnerStops[3] = "La Curacao";
        spinnerStops[4] = "Mcdonalds Utatlán";
        spinnerStops[5] = "Peri";
        spinnerStops[6] = "Tikal Futura";
        spinnerStops[7] = "Trebol";
        aBusStops = new ArrayAdapter<String>(ScrollingActivity.this, R.layout.simple_spinner_item, spinnerStops);
        aBusStops.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        SpinnerFrom.setAdapter(aBusStops);
        SpinnerTo.setAdapter(aBusStops);

        ImageView searchInitial = (ImageView) findViewById(R.id.imageSearchTitle);
        searchInitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutInitial.setVisibility(View.GONE);
                layoutSearch.setVisibility(View.VISIBLE);
            }
        });

        ImageView searchImg = (ImageView) findViewById(R.id.imageSearch);
        searchImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                rl_ubicacion.setVisibility(View.GONE);
                rl_destino.setVisibility(View.GONE);
                rl_buttons.setVisibility(View.GONE);
                showList();
            }
        });

        ImageView clearImg = (ImageView) findViewById(R.id.imageDrop);
        clearImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutList.setVisibility(View.GONE);
                layoutSearch.setVisibility(View.GONE);
                layoutInitial.setVisibility(View.VISIBLE);
            }
        });

        ImageView imagNew = (ImageView) findViewById(R.id.imagNew);
        imagNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutList.setVisibility(View.GONE);
                ll_searchNew.setVisibility(View.GONE);
                rl_ubicacion.setVisibility(View.VISIBLE);
                rl_destino.setVisibility(View.VISIBLE);
                rl_buttons.setVisibility(View.VISIBLE);
            }
        });

    }

    public void showList(){
        LayoutList.setVisibility(View.VISIBLE);
        ll_searchNew.setVisibility(View.VISIBLE);

        List<itemStops> xacts = new ArrayList<>();
        itemStops temp = new itemStops();
        temp.setRouteName("Ruta 1");
        temp.setStopName("Tikal futura");
        temp.setObservations("alsfjaksfalsdjfa");
        temp.setPrice("Q. 5.00");
        xacts.add(temp);

        itemStops temp2 = new itemStops();
        temp2.setRouteName("Ruta 2");
        temp2.setStopName("Trebol");
        temp2.setObservations("alsfjaksfalsdjfa");
        temp2.setPrice("Q. 5.00");
        xacts.add(temp2);

        adapter = new itemStopsAdapter(ScrollingActivity.this, R.layout.item_route, xacts);
        ListBus.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SecondClass {
        private static ScrollingActivity mActivityRef;

        public static void updateActivity() {
            mActivityRef = new ScrollingActivity();
        }

    }
}
