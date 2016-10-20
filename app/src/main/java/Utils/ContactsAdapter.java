package Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by clark on 2016/10/20.
 */

public class ContactsAdapter extends BaseAdapter {
    private List<HashMap<String,String>> mDataList;
    private LayoutInflater mLayoutInflater;

    public ContactsAdapter(Context context,List<HashMap<String, String>> dataList) {
        mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public HashMap<String, String> getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.contacts_item,null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.id_name);
            viewHolder.phone = (TextView) convertView.findViewById(R.id.id_phone);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(mDataList.get(position).get("name"));
        viewHolder.phone.setText(mDataList.get(position).get("phone"));
        return convertView;
    }

    class ViewHolder{
        TextView name;
        TextView phone;
    }
}
