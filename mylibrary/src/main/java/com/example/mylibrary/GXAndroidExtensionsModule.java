package com.example.mylibrary;

/**
 * Created by mirorodrigo on 18/12/2017.
 */

import android.content.Context;

import com.artech.externalapi.ExternalApiDefinition;
import com.artech.externalapi.ExternalApiFactory;
import com.artech.framework.GenexusModule;

public class GXAndroidExtensionsModule implements GenexusModule {

    @Override
    public void initialize(Context context) {
        ExternalApiDefinition mAPI = new ExternalApiDefinition(
                DispositivoName.NAME,
                DispositivoName.class
        );
        ExternalApiFactory.addApi(mAPI);
    }
}