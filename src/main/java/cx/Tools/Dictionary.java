package cx.Tools;

import java.util.List;

/**
 * Created by Administrator on 2017-8-16.
 */
public class Dictionary {

    public static final String TOKEN = "";
    public static final String APP_ID = "";
    public static final String APP_SECRET = "";
    public static final int SYS_APP_ID = 1;
    public static int APP_ROWS = 10;
    public static boolean IS_SAVE_ORIGINAL_PIC = false;
    public static float PIC_QUALITY = 0.25F;
    public static String MASTER_SECRET = "b84e021f0b2cc9e3cc227b4b";
    public static String APP_KEY = "a04ea057a5cc6029fcc51269";
    public static String globalTitle;
    public static List tokenList;

    public Dictionary()
    {
    }

    public static boolean isIS_SAVE_ORIGINAL_PIC()
    {
        return IS_SAVE_ORIGINAL_PIC;
    }

    public static void setIS_SAVE_ORIGINAL_PIC(boolean iS_SAVE_ORIGINAL_PIC)
    {
        IS_SAVE_ORIGINAL_PIC = iS_SAVE_ORIGINAL_PIC;
    }


}
