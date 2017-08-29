package cx.Tools;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017-8-16.
 */
public class Tools {

    private static Random random = new Random();
    private static SimpleDateFormat format_short = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat format_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat format_1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat format_2 = new SimpleDateFormat("yyyy-MM");

    public Tools()
    {
    }

    public static boolean isEmpty(String s)
    {
        if (s == null)
            return true;
        return s.trim().length() == 0;
    }

    public static boolean isNotEmpty(String s)
    {
        return s != null && s.trim().length() > 0;
    }

    public static String getCrumbs(String title)
    {
        if (title != null && title.indexOf("-") != -1)
            return title.split("-")[1];
        else
            return "当前页面";
    }

    public static String getSplitTime(String time, int index)
    {
        if (time == null || time.indexOf("-") == -1)
            return "";
        else
            return time.split("-")[index];
    }

    public static void info(Class clz, Object msg)
    {
        Logger.getLogger(clz).info(msg);
    }

    public static void error(Class clz, Object msg, Throwable e)
    {
        Logger.getLogger(clz).error(msg, e);
    }

    public static String getMD5Str(String str)
    {
        MessageDigest messageDigest = null;
        try
        {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        byte byteArray[] = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++)
            if (Integer.toHexString(0xff & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xff & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xff & byteArray[i]));

        return md5StrBuff.toString();
    }

    public static Date parseStringToDate(String source, boolean isShort) {
        if (source == null)
            return null;
        if (isShort)
            try {
                return format_short.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        try {
            return format_long.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ParseException e = null;
        e.printStackTrace();
        e.printStackTrace();
        return null;
    }

    public static String parseDateToString(Date date, boolean isShort)
    {
        if (date == null)
            return null;
        if (isShort)
            return format_short.format(date);
        else
            return format_long.format(date);
    }

    public static String parseNow_YM()
    {
        return format_2.format(new Date());
    }

    public static String getNowDate(boolean isShort)
    {
        return parseDateToString(new Date(), isShort);
    }

    public static boolean isBeforeDate(String date)
    {
            try {
                Date _date;
                Date _currentDate;
                _date = parseStringToDate(date, true);
                Calendar _c = new GregorianCalendar();
                _c.setTime(new Date());
                _c.add(5, -1);
                _currentDate = _c.getTime();
                return _currentDate.before(_date);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
    }

    public static String getToken()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Boolean checkedMenuRadio(List list, Integer id)
    {
        String _id = id.toString();
        return Boolean.valueOf(list.contains(_id));
    }

    public static Boolean isFixedLetterStart(String str, String fixedLetter)
    {
        if (str.indexOf(fixedLetter) == 0)
            return Boolean.valueOf(true);
        else
            return Boolean.valueOf(false);
    }

    public static String getSplitSeparator()
    {
        return ",";
    }

    public static String convertLineFeed(String s)
    {
        if (s == null)
            return "";
        else
            return s.replaceAll("\\n", "<br />");
    }

    public static String cn2Spell(String chinese)
    {
        StringBuffer pybf = new StringBuffer();
        char arr[] = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > '\200')
                try
                {
                    pybf.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
                }
                catch (Exception exception) { }
            else
                pybf.append(arr[i]);

        return pybf.toString();
    }

    public static String cn2FirstSpell(String chinese)
    {
        StringBuffer pybf = new StringBuffer();
        char arr[] = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > '\200')
                try
                {
                    String _t[] = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (_t != null)
                        pybf.append(_t[0].charAt(0));
                }
                catch (Exception exception) { }
            else
                pybf.append(arr[i]);

        return pybf.toString().replaceAll("\\W", "").trim();
    }

    public static boolean regexForName(String name)
    {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5]{2,10}$");
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static String encode(String content) {
        try {
            return URLEncoder.encode(content, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "no message";
    }

    public static String random8String(String prefix)
    {
        int randomInt = random.nextInt(0x5f5e100);
        StringBuffer _sb = new StringBuffer(String.valueOf(randomInt));
        StringBuffer _rvl = new StringBuffer(prefix);
        for (int i = 0; i < 8 - _sb.length(); i++)
            _rvl.append("0");

        _rvl.append(_sb);
        return _rvl.toString();
    }

    public static String random_bh(String prefix)
    {
        StringBuffer sb = new StringBuffer(prefix);
        String dateString = format_1.format(new Date());
        sb.append("-");
        sb.append(dateString);
        return sb.toString();
    }

    public static BigDecimal sumByList(List list)
    {
        if (list == null || list.size() == 0)
            return null;
        BigDecimal result = (BigDecimal)list.get(0);
        for (int i = 1; i < list.size(); i++)
            result = result.add((BigDecimal)list.get(i));

        return result;
    }

    public static BigDecimal avgByList(List list)
    {
        BigDecimal result = sumByList(list);
        if (result == null)
        {
            return result;
        } else
        {
            result = result.divide(new BigDecimal(Integer.toString(list.size())), 6, 4);
            return result;
        }
    }

    public static BigDecimal sqrt(BigDecimal num)
    {
        if (num.compareTo(BigDecimal.ZERO) < 0)
            return BigDecimal.ZERO;
        BigDecimal x;
        for (x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128); x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0;);
        return x;
    }

    private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n)
    {
        return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
    }

    public static String numberFormat(int min, int num)
    {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMinimumIntegerDigits(min);
        nf.setGroupingUsed(false);
        return nf.format(num);
    }

    public static String[] stringList2Array(List list)
    {
        String fields[] = null;
        if (list != null && list.size() > 0)
        {
            fields = new String[list.size()];
            list.toArray(fields);
        }
        return fields;
    }

    public static byte[] stream2Byte(InputStream in) throws IOException {

        try {
            byte b2[];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte b1[] = new byte[100];
            for (int len = 0; (len = in.read(b1, 0, b1.length)) > 0;)
                out.write(b1, 0, len);

            out.flush();
            b2 = out.toByteArray();
            out.close();
            return b2;
        }catch (IOException  e){
            e.printStackTrace();
            return null;
        }
    }

    public static InputStream byte2Stream(byte b[])
    {
        return new ByteArrayInputStream(b);
    }

    public static void main1(String args[])
    {
        String md5 = getMD5Str("123");
        System.out.println((new StringBuilder("md5: ")).append(md5).toString());
    }

    public static void main2(String args[])
    {
        BigDecimal b1 = new BigDecimal("0.00000000000000000000001");
        BigDecimal b2 = new BigDecimal("0.0000000000000000000001");
        System.out.println(b1.compareTo(b2));
    }

    public static void main(String args1[])
    {
    }

}
