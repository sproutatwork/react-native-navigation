package com.reactnativenavigation.params.parsers;

import android.os.Bundle;

import com.reactnativenavigation.params.NavigationParams;
import com.reactnativenavigation.params.OverlayParams;

public class OverlayParamsParser extends Parser {
    private static final String KEY_SCREEN = "screenId";
    private static final String KEY_NAVIGATION_PARAMS = "navigationParams";

    private static final String POSITION = "position";
    private static final String POSITION_TOP = "top";
    private static final String POSITION_LEFT = "left";
    private static final String POSITION_WIDTH = "width";
    private static final String POSITION_HEIGHT = "height";

    private static double getDouble(Object d, double defaultValue) {
        if(d instanceof Integer) {
            return ((int) d) * 1.0;
        }
        else if (d instanceof Double){
            return (double) d;
        }
        return defaultValue;
    }

    public static OverlayParams parse(Bundle params) {
        OverlayParams result = new OverlayParams();

        result.screenId = params.getString(KEY_SCREEN);
        assertKeyExists(params, KEY_NAVIGATION_PARAMS);
        result.navigationParams = new NavigationParams(params.getBundle(KEY_NAVIGATION_PARAMS));

        Bundle position = params.getBundle(POSITION);

        result.top = (int) getDouble(position.get(POSITION_TOP), 0);
        result.left = (int) getDouble(position.get(POSITION_LEFT), 0);
        if (result.top == 0 && result.left == 0) {
            result.top = position.getInt(POSITION_TOP);
            result.left = position.getInt(POSITION_LEFT);
        }
        result.width = position.getInt(POSITION_WIDTH);
        result.height = position.getInt(POSITION_HEIGHT);

        return result;
    }
}
