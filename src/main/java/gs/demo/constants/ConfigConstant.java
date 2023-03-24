package gs.demo.constants;

/**
 * <p>常量配置</p>
 *
 * @author gs
 * @since 2023/3/14 20:59
 */
public class ConfigConstant {

    /**
     * token过期时间，单位：分钟
     */
    public static Long TOKEN_EXPIRE = 4320l;

    /**
     * token加密盐
     */
    public static String TOKEN_SALT = "1qaz@WSX";

    /**
     * 默认密码
     */
    public static String DEFAULT_PWD = "123456";

    /**
     * 导出最大数量
     */
    public static Integer EXPORT_MAX_NUM = 3000;

}
