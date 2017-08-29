package cx.Tools;

/**
 * Created by Administrator on 2017-8-16.
 */
public interface ResultConfigurationDefinition {

    public static interface LoginActionConfiguration
    {

        public static final String LOGIN_SUCC_EMPLOYEE = "login_succ_employee";
        public static final String LOGIN_ERROR = "login_error";
        public static final String LOGOUT = "logout";
    }

    public static interface TurnActionConfiguration
    {

        public static final String TURN_SUCC = "turn_succ";
        public static final String TURN_NO_LOGIN = "turn_no_login";
    }


    public static final String JSON = "json";
}




