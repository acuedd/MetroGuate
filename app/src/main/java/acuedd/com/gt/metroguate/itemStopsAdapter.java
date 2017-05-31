package acuedd.com.gt.metroguate;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import acuedd.com.gt.metroguate.utils.itemStops;

/**
 * Created by edwardacu on 08/05/17.
 */

public class itemStopsAdapter extends ArrayAdapter<itemStops> {

    private List<itemStops> objects;
    private Context context;
    private int lastPosition = -1;

    public itemStopsAdapter(Context context, int resource, List<itemStops> objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.item_route, null);
        }

        itemStops item = objects.get(position);
        if(item != null && convertView != null){

            TextView txtH1 = (TextView) convertView.findViewById(R.id.tviewH1);
            TextView txtbus = (TextView) convertView.findViewById(R.id.txtbus);
            TextView txtobs = (TextView) convertView.findViewById(R.id.txtobs);
            TextView txtprice = (TextView) convertView.findViewById(R.id.lblfeeInfo);

            txtH1.setText(item.getRouteName());
            txtbus.setText(item.getStopName());
            txtobs.setText(item.getObservations());
            txtprice.setText(item.getPrice());

            ImageView vineta = (ImageView) convertView.findViewById(R.id.vineta);

            if(position % 2 == 0){
                vineta.setImageDrawable(context.getResources().getDrawable(R.drawable.circle_green));
                convertView.setBackgroundColor(context.getResources().getColor(R.color.colormain));
            }
            else{
                vineta.setImageDrawable(context.getResources().getDrawable(R.drawable.circle_red));
                convertView.setBackgroundColor(context.getResources().getColor(R.color.black_opaque));
            }

        }
        return convertView;
    }
}
