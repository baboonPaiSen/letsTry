package mybatis.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * app更新记录
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class App {
    /**
    * id
    */
    private Long id;

    /**
    * 版本号
    */
    private Integer versionCode;

    /**
    * 版本
    */
    private String versionString;

    /**
    * 更新消息
    */
    private String message;

    /**
    * 下载地址
    */
    private String url;

    /**
    * 程序文件大小
    */
    private Long size;

    /**
    * APP类型(0: 家长版(安卓手机) 1: 学生HD版(安卓) 2: 学生版(安卓) 3:教师版(安卓) 4:教师HD版(安卓) 5:应用市场(安卓平板) 6:定制平板桌面(安卓平板) 7: 家长版(IOS手机) 8: 学生HD版(IOS) 9: 学生版(IOS) 10:教师版(IOS) 11:教师HD版(IOS)
    */
    private Byte appType;

    /**
    * 强制升级状态（0--否，1--是，默认否）
    */
    private Byte forcedUpgradeStatus;

    /**
    * 最低支持版本号
    */
    private Integer minimumVersionCode;

    /**
    * 最低支持版本
    */
    private String minimumVersionString;

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