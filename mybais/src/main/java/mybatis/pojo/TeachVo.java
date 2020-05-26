package mybatis.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class TeachVo implements Serializable {

    private Teachplan teachplan;

    private String name;

    private List<String> idList;
}
