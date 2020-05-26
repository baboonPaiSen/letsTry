package src.letsTry;




import java.util.List;
import java.util.StringJoiner;

/**
 * flash-correct
 *
 * 返回消息对象
 *
 * @author Gent Liu
 */


public class ResponseMessage <T> implements ResponseInterface<T> {

    private static final ResponseMessage OK = new ResponseMessage<>(Code.CODE_SUCCESS, Message.MESSAGE_SUCCESS, null);

    private static final ResponseMessage PARAMETER_ERROR = new ResponseMessage<>(Code.CODE_UNKNOWN_ERROR, Message.MESSAGE_PARAMETER_ERROR, null);

    private static final ResponseMessage UNAUTHORIZED = new ResponseMessage<>(Code.CODE_UNAUTHORIZED, "未登录或登录信息失效", null);

    private static final ResponseMessage UNSUPPORTED_BUSINESS = new ResponseMessage<>(Code.UNSUPPORTED_BUSINESS, "不支持业务", null);

    /**
     * 返回码
     */

    private final Integer code;
    /**
     * 返回消息
     */

    private final String message;
    /**
     * 返回对象
     */

    private final T data;


    protected ResponseMessage() {
        this(Code.CODE_SUCCESS, null, null);
    }

    protected ResponseMessage(final Integer code, final String message, final T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public T getData() {
        return data;
    }


    /**
     * 静态构造函数
     */
    public static ResponseMessage error(final int code, final String message) {
        return new ResponseMessage<>(code, message, null);
    }

    public static <T> ResponseMessage<T> error(final int code, final String message, final T data) {
        return new ResponseMessage<>(code, message, data);
    }

    public static ResponseMessage success() {
        return OK;
    }

    public static ResponseMessage parameterError() {
        return PARAMETER_ERROR;
    }

    public static ResponseMessage unauthorized() {
        return UNAUTHORIZED;
    }

    public static ResponseMessage unsupportedBusiness() {
        return UNSUPPORTED_BUSINESS;
    }

    public static <T> ResponseMessage<T> success(final T data) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, Message.MESSAGE_SUCCESS, data);
    }

    public static ResponseMessage success(final String message) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, message, null);
    }

    public static <T> ResponseMessage<T> success(final String message, final T data) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, message, data);
    }

    public static <E> ResponseMessage<E[]> success(final E[] data) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, Message.MESSAGE_SUCCESS, data);
    }

    public static <E> ResponseMessage<Iterable<E>> success(final Iterable<E> data) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, Message.MESSAGE_SUCCESS, data);
    }

    public static <E> ResponseMessage<List<E>> success(final List<E> data) {
        return new ResponseMessage<>(Code.CODE_SUCCESS, Message.MESSAGE_SUCCESS, data);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseMessage.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + message + "'")
                .add("data=" + data)
                .toString();
    }

    public static void main(String[] args) {
        ResponseMessage.success( );
    }
}
