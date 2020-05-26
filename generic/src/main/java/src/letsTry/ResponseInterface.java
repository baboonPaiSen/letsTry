package src.letsTry;

public interface ResponseInterface<T> {
    /**
     * 获取返回码
     * @return
     */
    Integer getCode();

    /**
     * 获取返回消息
     * @return
     */
    String getMessage();

    /**
     * 获取返回对象
     * @return
     */
    T getData();
}
