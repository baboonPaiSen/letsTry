package mybatis.pojo;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table(name = "account")
public class Account  {
    @Id
    private Integer id;
    private Integer uid;
    private Double  money;
    private User user;
}
