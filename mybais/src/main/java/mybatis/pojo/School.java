package mybatis.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 学校表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    /**
    * ID
    */
    private Long id;

    /**
    * 学校名称
    */
    private String name;

    /**
    * 学校简称
    */
    private String simpleName;

    /**
    * 省
    */
    private String province;

    /**
    * 市
    */
    private String city;

    /**
    * 区
    */
    private String district;

    /**
    * 学校类型(1:学校 2:机构)
    */
    private Byte type;

    /**
    * 管理员Id[FK|user.id]
    */
    private Long adminId;

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