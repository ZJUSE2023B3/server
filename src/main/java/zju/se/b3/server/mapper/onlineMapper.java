package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.*;
import zju.se.b3.server.entity.chatRecord;
import zju.se.b3.server.entity.online;

import java.util.List;

@Mapper
public interface onlineMapper {

    @Insert("INSERT INTO online(user_id,login_time,user_status) VALUES (#{user_id},#{login_time},#{user_status})")
    void insert(online online1);

    @Delete("delete from online where user_id = #{user_id}")
    int delete(int user_id);

    @Select("select * from online")
    List<online> selectall();

    @Select("select * from online where user_id = #{user_id}")
    online select_by_userid(int user_id);

    @Select("select * from online where user_status = #{user_status}")
    List<online> select_by_status(String user_status);

    @Update("update online set user_status = #{user_status} where user_id = #{user_id}")
    int change_status(int user_id, String user_status);

}
