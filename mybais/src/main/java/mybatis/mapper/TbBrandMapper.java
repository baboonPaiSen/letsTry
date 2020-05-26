package mybatis.mapper;
import java.util.List;

import mybatis.pojo.BrandLeftJoinCategory;
import mybatis.pojo.TbBrand;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface TbBrandMapper extends Mapper<TbBrand> {

      List<BrandLeftJoinCategory> brandJoinCategory();
      TbBrand findByIdOrderByImage(@Param("id") Long id);


}