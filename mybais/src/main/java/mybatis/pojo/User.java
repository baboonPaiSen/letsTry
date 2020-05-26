package mybatis.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {

    private Integer id;
    private String  username;
    private Date   birthday;
    private Character sex;
    private String address;
    private List<Account> accounts;

}
