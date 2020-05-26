package src.letsTry;

/**
 * flash-correct
 * <p>
 * 定义返回码的含义
 *
 * @author Gent Liu
 */
public  class Code {

    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 0;
    /**
     * 未知错误
     */
    public static final int CODE_UNKNOWN_ERROR = -1;
    /**
     * 未登录或登录超时
     */
    public static final int CODE_UNAUTHORIZED = 401;
    /**
     * 没有设置密码
     */
    public static final int CODE_NO_PASSWORD = 402;

    /**
     * 没有权限访问
     */
    public static final int FORBIDDEN = 403;

    /**
     * 不支持业务
     */
    public static final int UNSUPPORTED_BUSINESS = 603;

    /**
     * 短信发送频率超限
     */
    public static final int CODE_MESSAGE_LIMIT_CONTROL = 601;
    /**
     * 注册时短信验证码失效
     */
    public static final int CODE_MESSAGE_INVALID_CODE = 602;

    /**
     * 班级用户存在同名
     */
    public static final int CODE_CLASS_USER_EXISTS_SAME_NAME = 701;

    /**
     * 使用二维码绑定家庭管理员提示码
     */
    public static final int BINGING_PRIMARY_GUARDIAN_USE_QR_CODE = 702;

    /**
     * 使用二维码绑定家庭管理员提示码
     */
    public static final int CLASS_EXISTS = 703;

    /**
     * 提前发回作业提示
     */
    public static final int WORK_EARLY_RETURN = 703;

    /**
     * 作业审核不通过提示
     */
    public static final int SCAN_WORK_UN_PASS = 1000;

    /**
     * 数据不存在
     */
    public static final int DATA_NOT_EXIST = 19;


    /**
     * 数据不合法
     */
    public static final int INVALID_DATA = 501;

    /**
     * 验证码校验不通过
     */

    public static final  int INVALID_CODE = 502;
}
