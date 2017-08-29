package cx.Tools;

import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017-8-16.
 */
public class GlobalData {

    private Properties authorityProperties;
    private String initPwd;
    private List nationList;
    private String globalTitle;
    private List tokenList;
    private boolean debug;

    public GlobalData()
    {
    }

    public Properties getAuthorityProperties()
    {
        return authorityProperties;
    }

    public void setAuthorityProperties(Properties authorityProperties)
    {
        this.authorityProperties = authorityProperties;
    }

    public String getGlobalTitle()
    {
        return globalTitle;
    }

    public void setGlobalTitle(String globalTitle)
    {
        this.globalTitle = globalTitle;
    }

    public List getNationList()
    {
        return nationList;
    }

    public void setNationList(List nationList)
    {
        this.nationList = nationList;
    }

    public String getInitPwd()
    {
        return initPwd;
    }

    public void setInitPwd(String initPwd)
    {
        this.initPwd = initPwd;
    }

    public List getTokenList()
    {
        return tokenList;
    }

    public void setTokenList(List tokenList)
    {
        this.tokenList = tokenList;
    }

    public boolean isDebug()
    {
        return debug;
    }

    public void setDebug(boolean debug)
    {
        this.debug = debug;
    }


}
