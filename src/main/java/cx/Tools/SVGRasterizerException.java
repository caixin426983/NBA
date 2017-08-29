package cx.Tools;

/**
 * Created by Administrator on 2017-8-16.
 */
public class SVGRasterizerException extends Exception {

    private static final long serialVersionUID = 0xb913abb15149748aL;
    private String mistake;

    public SVGRasterizerException()
    {
        mistake = "unknown to men";
    }

    public SVGRasterizerException(String err)
    {
        super(err);
        mistake = err;
    }

    public String getError()
    {
        return mistake;
    }

}
