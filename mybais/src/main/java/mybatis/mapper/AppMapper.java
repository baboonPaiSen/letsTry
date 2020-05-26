package mybatis.mapper;
import java.util.List;

import mybatis.pojo.App;
import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppMapper {
    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    List<App> selectByAppType(@Param("appType") Byte appType);


}