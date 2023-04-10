package zju.se.b3.server.mapper;


import org.apache.ibatis.annotations.*;
import zju.se.b3.server.entity.Friend;
import zju.se.b3.server.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select count(*) from User where user_name = #{user_name}")
    int select_by_username(String user_name);

    @Select("select count(*) from User where user_name = #{user_name} and user_passwd = #{user_passwd}")
    int select_by_username_and_passwd(String user_name,String user_passwd);

    @Insert("insert into User(user_name,user_passwd,email) values(#{user_name},#{user_passwd},#{email})")
    int insert(String user_name,String user_passwd,String email);
    
    public List<Friend> findall();

    public List<Friend> Select(Integer user_id);

    public Integer Add(Friend user);
    public Integer Delete(Friend user);
    
    public List<User> FindbyId(Integer user_id);
    public Integer ChangePassword(User user);
    public Integer Update(User user);

}
