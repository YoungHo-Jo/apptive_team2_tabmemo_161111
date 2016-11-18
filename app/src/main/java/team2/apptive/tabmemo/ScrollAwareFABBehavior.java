package team2.apptive.tabmemo;


import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.view.View;

public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

  @Override
  public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout,
                                     FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
    return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL ||
      super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
        nestedScrollAxes);
  }

}