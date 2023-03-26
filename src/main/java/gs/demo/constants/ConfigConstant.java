package gs.demo.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>常量配置</p>
 *
 * @author gs
 * @since 2023/3/14 20:59
 */
public class ConfigConstant {

    public static Map<String, String> configMap = new HashMap<>();

    /**
     * token过期时间，单位：分钟
     */
    public static Long TOKEN_EXPIRE = 4320l;
    public final static String TOKEN_EXPIRE_FIELD = "token_expire";

    /**
     * token加密盐
     */
    public static String TOKEN_SALT = "1qaz@WSX";
    public final static String TOKEN_SALT_FIELD = "token_salt";

    /**
     * 默认密码
     */
    public static String DEFAULT_PWD = "123456";
    public final static String DEFAULT_PWD_FIELD = "default_pwd";

    /**
     * 导出最大数量
     */
    public static Integer EXPORT_MAX_NUM = 3000;
    public final static String EXPORT_MAX_NUM_FIELD = "export_max_num";

}
