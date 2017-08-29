package cx.Tools;

/**
 * Created by Administrator on 2017-8-16.
 */
public class SysException extends RuntimeException {

    private static final long serialVersionUID = 0x627cd6f0215909fbL;

    public SysException(String msg)
    {
        super(msg);
    }

    public SysException(Throwable e)
    {
        super(e);
    }
}
