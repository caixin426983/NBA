package cx.Tools;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MyX509TrustManager
        implements X509TrustManager
{

    public MyX509TrustManager()
    {
    }

    public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
    {
    }

    public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
    {
    }

    public X509Certificate[] getAcceptedIssuers()
    {
        return null;
    }
}
