package cx.Tools;

/**
 * Created by Administrator on 2017-8-16.
 */
public class ConvertUtils {

    public ConvertUtils()
    {
    }

    public static boolean isIn(String substring, String source[])
    {
        if (source == null || source.length == 0)
            return false;
        for (int i = 0; i < source.length; i++)
        {
            String aSource = source[i];
            if (aSource.equals(substring))
                return true;
        }

        return false;
    }

    public static boolean isIn(String substring, String source)
    {
        if (source == null || substring == null)
        {
            return false;
        } else
        {
            String _arr[] = source.split(",");
            return isIn(substring, _arr);
        }
    }

    public static boolean isNotEmptyOrNull(String str)
    {
        return str != null && str.length() > 0;
    }
}
