package mybatis.pojo;

import lombok.Data;

import java.util.List;


@Data
public class BrandLeftJoinCategory extends TbBrand {

    List<TbCategory> categoryList ;
}
