package com.example.mylibrary;

import com.artech.actions.Action;
import com.artech.actions.ActionResult;
import com.artech.actions.ApiAction;
import com.artech.base.metadata.ActionDefinition;
import com.artech.base.metadata.DataSourceDefinitionList;
import com.artech.base.metadata.IDataSourceDefinition;
import com.artech.base.metadata.IDataViewDefinition;
import com.artech.base.metadata.InstanceProperties;
import com.artech.base.metadata.ObjectParameterDefinition;
import com.artech.base.metadata.VariableDefinition;
import com.artech.base.metadata.WorkWithDefinition;
import com.artech.base.metadata.enums.Connectivity;
import com.artech.base.metadata.layout.LayoutDefinition;
import com.artech.base.metadata.rules.RulesDefinition;
import com.artech.externalapi.ExternalApi;
import com.artech.externalapi.ExternalApiResult;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;
import com.artech.application.MyApplication;

import java.util.List;

/**
 * Created by mirorodrigo on 14/12/2017.
 */

public class DispositivoName extends ExternalApi {

    // GeneXus API Object Name
    final static String NAME = "DeviceName";
    String deviceName = "";

    // API Method Names
    private static final String getDeviceName = "getDeviceName";


    public DispositivoName(ApiAction action){
        super(action);

        addMethodHandler(getDeviceName,0, mShortToast);


    }

    @SuppressWarnings("FieldCanBeLocal")
    private final IMethodInvoker mShortToast = new IMethodInvoker() {
        @Override
        public @NonNull
        ExternalApiResult invoke(List<Object> parameters) {
            final String parValue = obtenerDeviceName();



            return new ExternalApiResult(ActionResult.SUCCESS_CONTINUE, parValue);
        }
    };



    private String obtenerDeviceName()
    {

        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        deviceName = capitalize(manufacturer) + " " + model;

        return deviceName;

    }



    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;
        String phrase = "";
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase += Character.toUpperCase(c);
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase += c;
        }
        return phrase;
    }
}
