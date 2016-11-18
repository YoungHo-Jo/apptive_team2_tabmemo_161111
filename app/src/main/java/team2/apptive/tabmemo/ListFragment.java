package team2.apptive.tabmemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.woxthebox.draglistview.DragListView;

import java.util.ArrayList;

/**
 * Created by solar on 2016-11-18.
 */

public class ListFragment extends Fragment {

  private ArrayList<Pair<Long, String>> mItemArray;
  private DragListView mDragListView;


  public static ListFragment newInstance() {
    return new ListFragment();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.mainid, container, false);

    mDragListView = (DragListView) view.findViewById(R.id.listviewid);
    mDragListView.getRecyclerView().setVerticalScrollBarEnabled(true);
    mDragListView.setDragListListener(new DragListView.DragListListener() {
      @Override
      public void onItemDragStarted(int position) {
        Toast.makeText(mDragListView.getContext(), "Start - position: " + position, Toast.LENGTH_SHORT).show();

      }

      @Override
      public void onItemDragging(int itemPosition, float x, float y) {

      }


      @Override
      public void onItemDragEnded(int fromPosition, int toPosition) {
        Toast.makeText(mDragListView.getContext(), "End - position: " + toPosition, Toast.LENGTH_SHORT).show();

      }
    });


    mItemArray = new ArrayList<>();
    for (int i = 0; i < 40; i++) {
      mItemArray.add(new Pair<>(Long.valueOf(i), "Item " + i));
    }


    return view;
  }


}
