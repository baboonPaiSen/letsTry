package mybatis.mapper;


import mybatis.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {



    List<Role>  findAll();
}
