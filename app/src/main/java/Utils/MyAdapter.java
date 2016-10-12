package Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clark.safeprotecter.R;

import java.util.List;

import Model.GridDataBean;

/**
 * Created by clark on 2016/10/12.
 */

public class MyAdapter extends BaseAdapter {
    private List<GridDataBean> mBeanList;
    private Context mContext;

    public MyAdapter(Context context, List<GridDataBean> datas) {
        mContext = context;
        mBeanList = datas;
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        MyViewHolder myViewHolder;
        if (convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.grid_item,null);
            myViewHolder = new MyViewHolder();
            myViewHolder.mImageView = (ImageView) view.findViewById(R.id.item_icon);
            myViewHolder.mTextView = (TextView) view.findViewById(R.id.item_text);
            view.setTag(myViewHolder);
        }else {
            view = convertView;
            myViewHolder = (MyViewHolder) view.getTag();
        }
        myViewHolder.mImageView.setImageResource(mBeanList.get(position).getIconid());
        myViewHolder.mTextView.setText(mBeanList.get(position).name);
        return view;
    }

    class MyViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
