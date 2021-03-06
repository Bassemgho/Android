// Generated by data binding compiler. Do not edit!
package com.example.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.login.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentShopBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout frameLayout;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  protected FragmentShopBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout frameLayout, RecyclerView recyclerView, TextView textView3,
      TextView textView4, TextView textView5) {
    super(_bindingComponent, _root, _localFieldCount);
    this.frameLayout = frameLayout;
    this.recyclerView = recyclerView;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @NonNull
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_shop, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentShopBinding>inflateInternal(inflater, R.layout.fragment_shop, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_shop, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentShopBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentShopBinding>inflateInternal(inflater, R.layout.fragment_shop, null, false, component);
  }

  public static FragmentShopBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentShopBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentShopBinding)bind(component, view, R.layout.fragment_shop);
  }
}
