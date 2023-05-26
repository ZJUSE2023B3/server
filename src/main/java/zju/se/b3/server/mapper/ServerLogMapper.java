package zju.se.b3.server.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zju.se.b3.server.entity.ServerLog;

import java.util.List;

@Mapper
public interface ServerLogMapper {

    @Insert("insert into ServerLog(log) VALUES (#{log})")
    int insert(String log);
    
    @Select("select * from ServerLog where create_at between #{begin} and #{end};")
    List<ServerLog> select_by_time(String begin, String end);


}
