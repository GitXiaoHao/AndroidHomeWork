package top.yh.homework.five.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import top.yh.homework.R;
import top.yh.homework.five.entity.CardInfo;

/**
 * @user
 * @date
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<CardInfo> list;

    public ListAdapter(Context context, List<CardInfo> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        //获取列表项的个数
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            //根据布局文件生成转换视图对象
            view = LayoutInflater.from(context).inflate(R.layout.item_five_list, null);
            viewHolder = new ViewHolder(view.findViewById(R.id.tv_time));
            //将视图持有者保存到转换视图中
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //给控件设置好数据
        CardInfo item = list.get(i);
        viewHolder.tvTime.setText(item.timer);
        return view;
    }
    public static final class ViewHolder{
        public TextView tvTime;

        public ViewHolder( TextView tvTime) {
            this.tvTime = tvTime;
        }
    }
}
