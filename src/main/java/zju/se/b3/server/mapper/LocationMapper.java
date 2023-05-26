package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import zju.se.b3.server.entity.Location;

@Mapper
public interface LocationMapper {
    @Insert("insert into Location (user_id,x,y,z,last_update) values (#{user_id},#{x},#{y},#{z},#{last_update});")
    int insert(Location location);

    @Update("update Location set x=#{x}, y=#{y}, z=#{z}, last_update=#{last_update} where user_id=#{user_id};")
    int update(Location location);

    @Select("select * from Location where user_id = #{user_id};")
    Location search(int user_id);

}
