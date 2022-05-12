package com.raisetech.javafull0504.controller;

import java.util.ArrayList;
import java.util.List;
import com.raisetech.javafull0504.entity.Player;
import com.raisetech.javafull0504.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;

// Model は Controller が View までデータを渡せるようにしてくれるクラス
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller アノテーションはHTMLなどのViewを返すようになる
@Controller
public class IndexController {

    private final PlayerMapper playerMapper;

    @Autowired  //コンストラクタインジェクション
    public IndexController(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    //value に配列を入れると、複数のパスに同じ動作を一度に割り当てられる
    // """ で囲むとコード内で便宜的に文字列を改行できる（実際のデータとしては改行されない）
    @RequestMapping(value = {"/", "/index", "index.html"} )
    public String noPath(Model model) {
        String setumei = """
            <p>1994-95シーズン終了後のオフ、ジョーダンはバスケットボールの体型を取り戻すべく、そして再び優勝を狙うために懸命にトレーニングを行った。</p>
            <p>オフにはジョーダン主演の映画撮影も行われたが、映画撮影の場所付近にジョーダン専用のバスケットボールゴールを設置。ジョーダンの呼びかけに、ピッペン、オニール、レジー・ミラーなどNBAの主力選手が集まり、ジョーダンと共に練習をした。後にジョーダンは、このオフの練習で従来のバスケットボールの感覚を取り戻し、相手選手の動きを把握できるようになったといった。</p>
            <p>1995-96シーズンが始まると、ブルズは快進撃を続け、NBA史上最高の勝利数を狙えるほどの勢いだった。ジョーダン、ピッペン、そしてかつての宿敵デトロイト・ピストンズでプレーしていたデニス・ロッドマンがサンアントニオ・スパーズから移籍してきてリーグ最強の3人組として注目を集めた。また、欧州出身の長身シューターであるトニー・クーコッチ、優秀なディフェンダーであるロン・ハーパーも陰からチームを支えた。ジョーダン自身は、1993年以前の強烈なスラムダンカーというよりは、技巧的なジャンプシューターとしてプレーしていたが、平均得点30.4で8度目の得点王に輝くことになる。</p>
            <p>シカゴ・ブルズは72勝10敗でレギュラーシーズンを終えた。この勝ち数はゴールデンステート・ウォリアーズが2015-16シーズンに記録するまでのレギュラーシーズン最多勝利記録(ウォリアーズが73勝9敗で新記録)であり、70勝を超えたチームも歴史上初だった。ブルズは数字上史上最強のチームとしてプレーオフに臨み、NBAファイナルでシアトル・スーパーソニックスと対戦。敵地のシアトルで2試合を落としたものの、6試合目にシカゴに戻り4度目の優勝を決めた。</p>
            <p>ジョーダンは再びファイナルMVPを受賞した。続く1996-97シーズン、ブルズは前シーズンより3勝少ない69勝でレギュラーシーズンを終える。プレーオフでは、このシーズンもブルズはファイナルに進出。ウェスタン・カンファレンスからは、ユタ・ジャズが勝ち上がってきた。史上屈指の名コンビと言われるジョン・ストックトンとレギュラーシーズンのMVPカール・マローンを相手に、シリーズは4勝2敗でブルズがものにする。初戦のブザービーターや敵地ソルトレイクシティでの病気を押してのパフォーマンスが注目されたジョーダンが再びMVPに選ばれた。ブルズとジョーダンの優勝回数は5回となっていた。</p>
            <p>続く1997-98シーズンは、フィル・ジャクソン監督がシーズン後の退任を早い時期から仄めかしており、ピッペンはチーム経営陣との関係を悪化させていた。強豪ブルズは今年で最後かという観測を、マスコミはジャクソンの表現を借りラストダンスという言葉で表した。復帰以降、マスコミやファンはしばしばジョーダンの年齢を話題にするようになっており、「いつまでプレーするか」が関心の的になっていた。ジョーダンは「ジャクソン監督とピッペンが辞めれば自分も辞める」と発言していたが、自身の進退については明言を避けていた。このシーズンはブルズの2度目の「スリーピート」がかかっており、様々な意味で注目を集めることになった。</p>
            <p>ブルズはNBAファイナルに進出し、対戦相手はこの年もユタ・ジャズだった。両チームともレギュラーシーズンは62勝20敗だったが、シーズン中の対戦成績に勝っていたユタ・ジャズがホームコートアドバンテージを得ていた。5戦目までで3勝2敗でシリーズの舞台をユタに戻し、臨んだ第6戦、ジョーダンは残り5.2秒で決勝シュートを決め、ブルズに6度目の優勝と2回目のスリーピートをもたらした。この時、解説者のアイザイア・トーマスは「第4クウォーターのマイケルは殺し屋 (killer) だ」と述べた。</p>
            <p>ジョーダンはシーズン終了後の1999年1月13日に2度目の引退を発表した。</p>
            """;
        model.addAttribute("jordan", setumei);
        return "/index";
    }

    @RequestMapping("/chicagobulls")
    public String chicagobulls(Model model) {
        // [players] テーブルから Player リストを入手
        // Player リストから Player を取り出し getName() で名前のString を得る
        // For文でコレを繰り返し、選手名のリスト List<String> playerNames を作成する
        List<Player> bullsPlayerList = playerMapper.findAll();
        Player bullsPlayer;
        List<String> playerNames = new ArrayList<>();
        for (int playercount = 0; playercount < bullsPlayerList.size(); playercount++) {
            bullsPlayer = bullsPlayerList.get(playercount);
            playerNames.add(bullsPlayer.getName());
        }

        // Thymeleaf 側で 選手名リストを使えるようにする
        model.addAttribute("playerNames", playerNames);
        return "/chicagobulls";
    }

}
