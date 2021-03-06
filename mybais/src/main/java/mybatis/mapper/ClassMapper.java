package mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);
}