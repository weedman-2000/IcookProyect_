package com.fmb.icookproyect_;

import androidx.fragment.app.Fragment;

/* Host de Navegacion*/
public interface NavigationHost
{
    /*disparador y puedo ir en reversa*/
    void navigateTo(Fragment fragment, boolean addToBackstack);
}