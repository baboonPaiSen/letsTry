package mybatis.Vo;


import lombok.Data;
import mybatis.pojo.Work;
import mybatis.pojo.WorkStudent;

/**
 * @description: TODO
 * @date: 2020/5/15 19:57
 * @author: ShangKun
 * @version: 2.0.0
 */
@Data
public class WorkJoinWorkStudent extends Work {

    private WorkStudent workStudent;
}
