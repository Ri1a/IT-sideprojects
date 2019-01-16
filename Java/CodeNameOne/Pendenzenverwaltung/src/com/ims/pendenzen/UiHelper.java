package com.ims.pendenzen;

/**
 *
 * @author Michael Schneider <michael.schneider@bbbaden.ch>
 */
public final class UiHelper {

    private static UiHelper uiHelper;

    private UiHelper() {

    }

    public static UiHelper getInstance() {
        if (uiHelper == null) {
            uiHelper = new UiHelper();
        }
        return uiHelper;
    }

    public String getNumberFormated(final double number, final int decimals) {
        final String numberString = String.valueOf(number);
        String ret = numberString;

        final int pointPos = numberString.indexOf('.');
        final int endPos = pointPos + decimals + 1;
        if (pointPos > 0 && endPos < numberString.length()) {
            ret = numberString.substring(0, endPos);
        }
        return ret;
    }

}
