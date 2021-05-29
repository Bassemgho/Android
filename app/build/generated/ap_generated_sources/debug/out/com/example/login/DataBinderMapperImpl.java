package com.example.login;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.login.databinding.ActivityHomeBindingImpl;
import com.example.login.databinding.FragmentBlankBindingImpl;
import com.example.login.databinding.FragmentShopBindingImpl;
import com.example.login.databinding.FragmentSigninCaissierBindingImpl;
import com.example.login.databinding.LoginTabFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYHOME = 1;

  private static final int LAYOUT_FRAGMENTBLANK = 2;

  private static final int LAYOUT_FRAGMENTSHOP = 3;

  private static final int LAYOUT_FRAGMENTSIGNINCAISSIER = 4;

  private static final int LAYOUT_LOGINTABFRAGMENT = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.login.R.layout.activity_home, LAYOUT_ACTIVITYHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.login.R.layout.fragment_blank, LAYOUT_FRAGMENTBLANK);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.login.R.layout.fragment_shop, LAYOUT_FRAGMENTSHOP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.login.R.layout.fragment_signin_caissier, LAYOUT_FRAGMENTSIGNINCAISSIER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.login.R.layout.login_tab_fragment, LAYOUT_LOGINTABFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYHOME: {
          if ("layout/activity_home_0".equals(tag)) {
            return new ActivityHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTBLANK: {
          if ("layout/fragment_blank_0".equals(tag)) {
            return new FragmentBlankBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_blank is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSHOP: {
          if ("layout/fragment_shop_0".equals(tag)) {
            return new FragmentShopBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_shop is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNINCAISSIER: {
          if ("layout/fragment_signin_caissier_0".equals(tag)) {
            return new FragmentSigninCaissierBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_signin_caissier is invalid. Received: " + tag);
        }
        case  LAYOUT_LOGINTABFRAGMENT: {
          if ("layout/login_tab_fragment_0".equals(tag)) {
            return new LoginTabFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for login_tab_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_home_0", com.example.login.R.layout.activity_home);
      sKeys.put("layout/fragment_blank_0", com.example.login.R.layout.fragment_blank);
      sKeys.put("layout/fragment_shop_0", com.example.login.R.layout.fragment_shop);
      sKeys.put("layout/fragment_signin_caissier_0", com.example.login.R.layout.fragment_signin_caissier);
      sKeys.put("layout/login_tab_fragment_0", com.example.login.R.layout.login_tab_fragment);
    }
  }
}
