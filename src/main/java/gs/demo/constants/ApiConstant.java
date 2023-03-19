package gs.demo.constants;

/**
 * <p>API常量</p>
 *
 * @author gs
 * @since 2023/3/14 21:26
 */
public interface ApiConstant {

    /** 验证码 */
    String LOGIN_CODE = "login/code";
    /** 登录 */
    String USER_LOGIN = "login";

    /** 用户信息 */
    String USER_INFO = "user/info";
    String USER_PAGE_LIST = "user/pageList";
    String USER_DETAIL = "user/detail";
    String USER_BATCH_ADD = "user/batchAdd";
    String USER_EDIT = "user/edit";
    String USER_RESET_PWD = "user/restPwd";
    String USER_DELETE = "user/delete";
    String USER_BATCH_DELETE = "user/batchDelete";
    String USER_IMPORT = "user/import";
    String USER_EXPORT = "user/export";

    /** 班级信息 */
    String CLASS_PAGE_LIST = "class/pageList";
    String CLASS_ADD = "class/add";
    String CLASS_DETAIL = "class/detail";
    String CLASS_UPDATE = "class/update";
    String CLASS_DELETE = "class/delete";
    String CLASS_TEACHER_LIST = "class/teacherList";

    /** 班级 - 学生 关系 */
    String CLASS_STUDENT_PAGE_LIST = "classStudent/pageList";
    String CLASS_STUDENT_BATCH_OPERATE = "classStudent/batchOperate";
    String CLASS_STUDENT_LIST = "classStudent/list";
    String CLASS_STUDENT_OPERATE_STUDENT_LIST = "classStudent/operateStudentList";
    String CLASS_STUDENT_BATCH_DELETE = "classStudent/batchDelete";

}
