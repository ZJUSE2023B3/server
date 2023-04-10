package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zju.se.b3.server.entity.chatRecord;

@Mapper
public interface ChatMapper {
    @Insert("INSERT INTO chatRecord VALUES (#{id},#{user_id},#{friend_id},#{message},#{created_at})," +
            "(#{id},#{friend_id},#{user_id},#{message},#{created_at})")
    void insert(chatRecord chatrecord);

    @Select("SELECT * FROM chatRecord WHERE user_id = #{user_id}")
    chatRecord[] findByUserid(Long user_id);

    @Select("SELECT * FROM chatRecord WHERE id = #{id}")
    chatRecord findByid(Long id);

    @Delete("DELETE FROM chatRecord WHERE id = #{id}")
    void delete(Long id);

}
