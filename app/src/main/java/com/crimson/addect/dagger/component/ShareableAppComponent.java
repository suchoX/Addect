package com.crimson.addect.dagger.component;

import com.crimson.addect.utils.SharedPrefs;

public interface ShareableAppComponent {
  SharedPrefs provideAppPrefs();
}
