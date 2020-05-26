package mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbCategory {

    private Long id;

    private String name;

    private Long parentId;

    private Boolean isParent;

    private Integer sort;
}