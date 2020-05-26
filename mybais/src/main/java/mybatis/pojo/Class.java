package mybatis.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 班级表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    /**
    * ID
    */
    private Long id;

    /**
    * 班级类型[0:常规班 1:错题班]
    */
    private Byte type;

    /**
    * 班级名称
    */
    private String name;

    /**
    * 学校id[FK|school.id]
    */
    private Long schoolId;

    /**
    * 年级id[FK|grade.id]
    */
    private Long gradeId;

    /**
    * 班级码
    */
    private Long classCode;

    /**
    * 创建者id[FK|user.id]
    */
    private Long creatorId;

    /**
    *  是否允许自由加入(0:不允许 1:允许)
    */
    private Byte free;

    /**
    * 是否毕业[Boolean|0:否 1:是]
    */
    private Byte graduated;

    /**
    * 学生人数
    */
    private Integer studentNum;

    /**
    * 状态(0:正常 1:禁用 2:删除)
    */
    private Byte status;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 修改时间
    */
    private Date updatedAt;
}