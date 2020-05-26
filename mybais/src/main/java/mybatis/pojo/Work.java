package mybatis.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 作业表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    /**
    * ID
    */
    private Long id;

    /**
    * 班级id[FK|class.id]
    */
    private Long classId;

    /**
    * 学校id[FK|school.id]
    */
    private Long schoolId;

    /**
    * 作业名称
    */
    private String name;

    /**
    * 发布时间
    */
    private Date releaseTime;

    /**
    * 截止时间
    */
    private Date endTime;

    /**
    * 科目Id[FK|grade.id]
    */
    private Long gradeId;

    /**
    * 科目id[FK|subject.id]
    */
    private Integer subjectId;

    /**
    * 作业项json
    */
    private String item;

    /**
    * 布置作业文字信息
    */
    private String content;

    /**
    * 作业发布状态(0:已发布 1:模板制作中 2: 已匹配模板 3:已批改)
    */
    private Byte workStatus;

    /**
    * 作业发回时间
    */
    private Date returnTime;

    /**
    * 共同Id(当两个作业共同Id相当时，为共用作业)
    */
    private Long togetherId;

    /**
    * 创建者id
    */
    private Long creatorId;

    /**
    * 客服id
    */
    private Long serviceId;

    /**
    * 状态(0:正常 1:禁用 2:删除)
    */
    private Byte status;

    /**
    * 内容审核任务Id
    */
    private Long scanJobId;

    /**
    * 内容审核状态 [Enum|0:待审核, 1:安全, 2:违规]
    */
    private Byte scanStatus;

    /**
    * 作业图片检阅状态[Enum|0:待检阅, 1:检阅中, 2:已检阅]
    */
    private Byte reviewStatus;

    /**
    * 是否允许补交作业 [Boolean|0:否, 1:是]
    */
    private Byte isSadlAllowed;

    /**
    * 辅导教师Id[FK|user.id]
    */
    private Long assistantId;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 修改时间
    */
    private Date updatedAt;
}