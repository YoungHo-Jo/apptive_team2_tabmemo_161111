package team2.apptive.tabmemo;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class BaseExpandableAdapter extends BaseExpandableListAdapter{

  private ArrayList<String> groupList = null;
  private ArrayList<ArrayList<String>> childList = null;
  private LayoutInflater inflater = null;
  private ViewHolder viewHolder = null;

  public BaseExpandableAdapter(Context c, ArrayList<String> groupList,
                               ArrayList<ArrayList<String>> childList){
    super();
    this.inflater = LayoutInflater.from(c);
    this.groupList = groupList;
    this.childList = childList;
  }

  // 그룹 포지션을 반환한다.
  @Override
  public String getGroup(int groupPosition) {
    return groupList.get(groupPosition);
  }

  // 그룹 사이즈를 반환한다.
  @Override
  public int getGroupCount() {
    return groupList.size();
  }

  // 그룹 ID를 반환한다.
  @Override
  public long getGroupId(int groupPosition) {
    return groupPosition;
  }

  // 그룹뷰 각각의 ROW
  @Override
  public View getGroupView(int groupPosition, boolean isExpanded,
                           View convertView, ViewGroup parent) {

    View v = convertView;

    if(v == null){
      viewHolder = new ViewHolder();
      v = inflater.inflate(R.layout.list_item, parent, false);
      viewHolder.tv_groupName = (TextView) v.findViewById(R.id.row_text);
      viewHolder.iv_image = (ImageView) v.findViewById(R.id.rowbar_image1);
      viewHolder.iv_image = (ImageView) v.findViewById(R.id.rowbar_image2);
      v.setTag(viewHolder);
    }else{
      viewHolder = (ViewHolder)v.getTag();
    }

    // 그룹을 펼칠때와 닫을때 아이콘을 변경해 준다.
    if(isExpanded){
      viewHolder.iv_image.setBackgroundColor(Color.GREEN);
    }else{
      viewHolder.iv_image2.setBackgroundColor(Color.WHITE);
    }

    viewHolder.tv_groupName.setText(getGroup(groupPosition));

    return v;
  }

  // 차일드뷰를 반환한다.
  @Override
  public String getChild(int groupPosition, int childPosition) {
    return childList.get(groupPosition).get(childPosition);
  }

  // 차일드뷰 사이즈를 반환한다.
  @Override
  public int getChildrenCount(int groupPosition) {
    return childList.get(groupPosition).size();
  }

  // 차일드뷰 ID를 반환한다.
  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
  }

  // 차일드뷰 각각의 ROW
  @Override
  public View getChildView(int groupPosition, int childPosition,
                           boolean isLastChild, View convertView, ViewGroup parent) {

    View v = convertView;

    if(v == null){
      viewHolder = new ViewHolder();
      v = inflater.inflate(R.layout.child_list_item, null);
      viewHolder.tv_child_image = (ImageView) v.findViewById(R.id.child_image);
      viewHolder.tv_child_image2 = (ImageView) v.findViewById(R.id.child_text);
      viewHolder.tv_childName = (TextView) v.findViewById(R.id.child_image2);
      v.setTag(viewHolder);
    }else{
      viewHolder = (ViewHolder)v.getTag();
    }

    viewHolder.tv_childName.setText(getChild(groupPosition, childPosition));

    return v;
  }

  @Override
  public boolean hasStableIds() {	return true; }

  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }

  class ViewHolder {
    public ImageView iv_image;
    public ImageView iv_image2;
    public TextView tv_groupName;
    public TextView tv_childName;
    public ImageView tv_child_image;
    public ImageView tv_child_image2;
  }

}




