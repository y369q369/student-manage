package gs.demo.constants;

/**
 * <p>API常量</p>
 *
 * @author gs
 * @since 2023/3/14 21:26
 */
public interface ApiConstant {

    /** 验证码 */
    String IDENTIFYING_CODE = "identifyingCode";
    /** 登录 */
    String LOGIN = "login";

    /** 通用 */
    String LIST = "list";
    String PAGE_LIST = "pageList";
    String ADD = "add";
    String DETAIL = "detail";
    String UPDATE = "update";
    String DELETE = "delete";
    String BATCH_ADD = "batchAdd";
    String BATCH_DELETE = "batchDelete";
    String IMPORT = "import";
    String EXPORT = "export";
    String ECHARTS_PIE = "echarts/pie";

    /** 用户 */
    String USER_INFO = "info";
    String USER_RESET_PWD = "restPwd";

    /** 班级信息 */
    String CLASS_TEACHER_LIST = "teacher/list";

    /** 班级 - 学生 关系 */
    String CLASS_STUDENT_BATCH_OPERATE = "batchOperate";
    String CLASS_STUDENT_STUDENT_LIST = "student/list";
    String CLASS_STUDENT_OPERATE_STUDENT_LIST = "operateStudent/list";

}
