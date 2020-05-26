package mybatis.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 学生作业表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkStudent {
    /**
    * ID
    */
    private Long id;

    /**
    * 作业id[FK|work.id]
    */
    private Long workId;

    /**
    * 学生id[FK|user.id]
    */
    private Long studentId;

    /**
    * 提交时间
    */
    private Date commitTime;

    /**
    * 作业发布状态(0:未提交 1:提交 2:已匹配模板 3:已批改 4:未改完 5:未批改)
    */
    private Byte corrected;

    /**
    * 是否已匹配状态(1:是，0:否)
    */
    private Byte matchStatus;

    /**
    * 发送匹配请求次数
    */
    private Byte matchRequestCount;

    /**
    * 是否有辅导更新状态(0-否 1-是)
    */
    private Byte coachingUpdateStatus;

    /**
    * 是否已读
    */
    private Boolean readStatus;

    /**
    * 辅导教师是否已批改[Boolean|0:否 1:是]
    */
    private Byte assistantCorrectStatus;

    /**
    * 状态(0:正常 1:禁用 2:删除)
    */
    private Byte status;

    /**
    * 是否被退回重做 [Boolean|0:否, 1:是]
    */
    private Byte isRejected;

    /**
    * 退回重做原因
    */
    private String rejectedReason;

    /**
    * 创建时间
    */
    private Date createdAt;

    /**
    * 修改时间
    */
    private Date updatedAt;
}