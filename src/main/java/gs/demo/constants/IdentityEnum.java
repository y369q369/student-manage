package gs.demo.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p></p>
 *
 * @author gs
 * @since 2023/3/18 23:10
 */
@Getter
@AllArgsConstructor
public enum IdentityEnum {

    STUDENT(0, "学生"),
    TEACHER(1, "教师"),
    ;

    private int code;

    private String name;

}
