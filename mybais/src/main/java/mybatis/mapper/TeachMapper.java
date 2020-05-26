package mybatis.mapper;


import mybatis.pojo.TeachVo;
import mybatis.pojo.Teachplan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachMapper {

    List<Teachplan> findAll();

    void insert(Teachplan teachplan);

    void  update(Teachplan teachplan);

    void  delete(String id);

    Teachplan selectById(String id);

    List<Teachplan>  selectByPnameLike(String pname);

    Long selectTotal();

    List<Teachplan> selectByVo(TeachVo vo);

    List<Teachplan> selectByCondition(Teachplan teachplan);

    List<Teachplan> selectByIdList(TeachVo vo);
}
