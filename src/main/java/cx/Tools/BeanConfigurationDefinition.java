package cx.Tools;

/**
 * Created by Administrator on 2017-8-16.
 */
public interface BeanConfigurationDefinition {
    public static interface ActionConfiguration
    {

        public static final String SECURITY_CODE_IMAGE_ACTION = "securityCodeImageAction";
    }

    public static interface ListenerConfiguraiton
    {
    }

    public static interface TestServiceRemoteConfiguration
    {

        public static final String REMOTE = "testServiceRemote";
    }


    public static final String COMPREHENSIVE_SERVICE = "comprehensiveService";
    public static final String GLOBAL_DATA = "globalData";
}
