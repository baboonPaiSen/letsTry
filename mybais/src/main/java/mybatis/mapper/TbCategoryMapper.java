package mybatis.mapper;


import mybatis.pojo.TbCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbCategory record);

    int insertSelective(TbCategory record);

    TbCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbCategory record);

    int updateByPrimaryKey(TbCategory record);
}