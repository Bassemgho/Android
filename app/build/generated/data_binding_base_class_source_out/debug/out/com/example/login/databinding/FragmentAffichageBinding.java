// Generated by data binding compiler. Do not edit!
package com.example.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.login.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentAffichageBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout par;

  @NonNull
  public final RecyclerView rec;

  protected FragmentAffichageBinding(Object _bindingComponent, View _root, int _localFieldCount,
      RelativeLayout par, RecyclerView rec) {
    super(_bindingComponent, _root, _localFieldCount);
    this.par = par;
    this.rec = rec;
  }

  @NonNull
  public static FragmentAffichageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_affichage, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAffichageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentAffichageBinding>inflateInternal(inflater, R.layout.fragment_affichage, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAffichageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_affichage, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAffichageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentAffichageBinding>inflateInternal(inflater, R.layout.fragment_affichage, null, false, component);
  }

  public static FragmentAffichageBinding bind(@NonNull View view) {
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
  public static FragmentAffichageBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentAffichageBinding)bind(component, view, R.layout.fragment_affichage);
  }
}
