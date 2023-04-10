package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import zju.se.b3.server.entity.chatRecord;

import java.util.List;

@Mapper
public interface ChatMapper {

    @Insert("INSERT INTO chatRecord(user_id,friend_id,message) VALUES (#{user_id},#{friend_id},#{message})," +
            "(#{friend_id},#{user_id},#{message})")
    void insert(chatRecord chatrecord);

    @Select("SELECT * FROM chatRecord WHERE user_id = #{user_id} and friend_id = #{friend_id}")
    List<chatRecord> findByUserid(Long user_id, Long friend_id);

    @Select("SELECT * FROM chatRecord WHERE id = #{id}")
    chatRecord findByid(Long id);

    @Delete("DELETE FROM chatRecord WHERE id = #{id}")
    void delete(Long id);

}
