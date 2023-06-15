package top.yh.homework.three.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import top.yh.homework.R;
import top.yh.homework.three.entity.Fruit;

/**
 * @user
 * @date
 */
public class ThreeAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> list;

    public ThreeAdapter(Context context, List<Fruit> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_fruit, null);
            viewHolder = new ViewHolder(view.findViewById(R.id.iv_icon),
                    view.findViewById(R.id.tv_name));
            //将视图持有者保存到转换视图中
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //给控件设置好数据
        Fruit item = list.get(i);
        viewHolder.ivIcon.setImageResource(item.img);
        viewHolder.tvName.setText(item.name);
        return view;
    }
    public static final class ViewHolder{
        public ImageView ivIcon;
        public TextView tvName;

        public ViewHolder(ImageView ivIcon, TextView tvName) {
            this.ivIcon = ivIcon;
            this.tvName = tvName;
        }
    }
}
