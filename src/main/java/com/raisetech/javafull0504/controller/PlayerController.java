package com.raisetech.javafull0504.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.raisetech.javafull0504.mapper.PlayerMapper;


// @RestController はJSONやXMLなどのAPI的なデータを返すようになる
@RestController
public class PlayerController {
    
    // PlayerMapper.java でDIコンテナに登録された PlayerMapper クラスをここで呼び出せる？
    @Autowired
    PlayerMapper playerMapper;

    // [/players] にアクセスした時の実際の動作
    // GetMapping は以下を置き換えたアノテーションとなっているだけのもの
    // @RequestMapping("/players", method = RequestMethod.GET)

    @GetMapping("/jordan")
    public String jordan() {
        return playerMapper.airJordan();
    }

}
