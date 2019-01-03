package com.example.fm404.rentalz;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by fm404 on 28/02/2018.
 */

public class FontManager {

    static final String ROOT = "fonts/", FONTAWESOME = ROOT + "fontawesome-webfont.ttf";

    static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }
}