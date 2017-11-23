package com.reactnativenavigation.params.parsers;

import android.os.Bundle;

import com.reactnativenavigation.params.ActivityParams;
import com.reactnativenavigation.params.AppStyle;
import com.reactnativenavigation.params.SideMenuParams;
import com.reactnativenavigation.views.SideMenu;

public class ActivityParamsParser extends Parser {
    private static final String PARAM_SCREEN = "screen";
    private static final String PARAM_TABS = "tabs";
    private static final String PARAM_SIDE_MENU = "sideMenu";
    private static final String PARAM_OVERLAY = "overlay";
    private static final String PARAM_ANIMATE_SHOW = "animateShow";

    public static ActivityParams parse(Bundle params) {
        ActivityParams result = new ActivityParams();

        AppStyle.setAppStyle(params);

        if (hasKey(params, PARAM_SCREEN)) {
            result.type = ActivityParams.Type.SingleScreen;
            result.screenParams = ScreenParamsParser.parse(params.getBundle(PARAM_SCREEN));
        }

        if (hasKey(params, PARAM_TABS)) {
            result.type = ActivityParams.Type.TabBased;
            result.tabParams = new ScreenParamsParser().parseTabs(params.getBundle(PARAM_TABS));
        }

        if (hasKey(params, PARAM_SIDE_MENU)) {
            SideMenuParams[] sideMenus = SideMenuParamsParser.parse(params.getBundle(PARAM_SIDE_MENU));
            result.leftSideMenuParams = sideMenus[SideMenu.Side.Left.ordinal()];
            result.rightSideMenuParams = sideMenus[SideMenu.Side.Right.ordinal()];
        }

        if (hasKey(params, PARAM_OVERLAY)) {
            result.overlayParams =  OverlayParamsParser.parse(params.getBundle(PARAM_OVERLAY));
        }

        result.animateShow = params.getBoolean(PARAM_ANIMATE_SHOW, true);

        return result;
    }
}
