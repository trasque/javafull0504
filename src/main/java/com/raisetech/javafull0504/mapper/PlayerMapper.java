package com.raisetech.javafull0504.mapper;

import java.util.List;

// 階層分けしたので Player.java のクラスをインポートする
import com.raisetech.javafull0504.entity.Player;

// MyBatis を使用してマッピングするためのインポート
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// Mapperはインターフェースで用意する
// たぶんDIコンテナってヤツに PlayerMapper が登録されてる気がする
@Mapper
public interface PlayerMapper {

    @Select("SELECT * FROM players")
    List<Player> findAll();

    @Select("SELECT name FROM players WHERE id=1")
    String airJordan();
}
