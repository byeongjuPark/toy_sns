package com.bangil.toy_sns.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

import com.bangil.toy_sns.domain.Board;
import com.bangil.toy_sns.domain.BoardFileAttach;

@Mapper
public interface BoardMapper {
    //@Insert("INSERT INTO BOARD values(b_seq.nextval, #{writerSeq}, #{content}, 0, SYSDATE, #{fileExisted})")
    @Insert("INSERT INTO BOARD (board_seq, writer_seq, content, like_count, write_date, file_existed) values(b_seq.nextval, #{writerSeq}, #{content}, 0, SYSDATE, #{fileExisted})")
    @SelectKey(statement="SELECT b_seq.currval as boardSeq FROM dual", keyProperty="boardSeq", before=false, resultType=Long.class)
    int insertBoard(Board board);
    
    @Insert("INSERT INTO BOARD_FILE_ATTACH values(#{boardSeq}, #{originalFileName}, #{filePath})")
    void insertBoardFileAttach(BoardFileAttach boardFileAttach);
}
