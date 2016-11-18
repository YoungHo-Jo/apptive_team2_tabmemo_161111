package team2.apptive.tabmemo;

/**
 * Created by solar on 2016-11-18.
 */

import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.woxthebox.draglistview.DragItemAdapter;

import java.util.ArrayList;

public class ItemAdapter extends DragItemAdapter<Pair<Long, String>, ItemAdapter.ViewHolder> {

  private int mLayoutId;
  private int mGrabHandleId;
  private boolean mDragOnLongPress;

  // grabHandledID를 통해서 눌렀을때 동작할 위치 지정 가능
  public ItemAdapter(ArrayList<Pair<Long, String>> list, int layoutId, int grabHandleId, boolean dragOnLongPress) {
    mLayoutId = layoutId;
    mGrabHandleId = grabHandleId;
    mDragOnLongPress = dragOnLongPress;
    setHasStableIds(true);
    setItemList(list);
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    super.onBindViewHolder(holder, position);
    String text = mItemList.get(position).second;
    holder.mText.setText(text);
    holder.itemView.setTag(text);
  }

  @Override
  public long getItemId(int position) {
    return mItemList.get(position).first;
  }

  public class ViewHolder extends DragItemAdapter.ViewHolder {
    public TextView mText;

    public ViewHolder(final View itemView) {
      super(itemView, mGrabHandleId, mDragOnLongPress);
      mText = (TextView) itemView.findViewById(R.id.text);
    }

    @Override
    public void onItemClicked(View view) {
      Toast.makeText(view.getContext(), "Item clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClicked(View view) {
      Toast.makeText(view.getContext(), "Item long clicked", Toast.LENGTH_SHORT).show();
      return true;
    }
  }
}
