package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select count(*) from User where user_name = #{user_name}")
    int select_by_username(String user_name);

    @Select("select count(*) from User where user_name = #{user_name} and user_passwd = #{user_passwd}")
    int select_by_username_and_passwd(String user_name,String user_passwd);

    @Insert("insert into User(user_name,user_passwd,email) values(#{user_name},#{user_passwd},#{email})")
    int insert(String user_name,String user_passwd,String email);

}
