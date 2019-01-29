package com.fei.springboot.websocket6663.util;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.websocket6663.games.game_wzq;

/**
 * Created by Administrator on 2019/1/2.
 */
public class GameInfo {
    //五子棋
    public static final int wzq_game=0;
    //十点半
    public static final int sdb_game=1;
    //十点半，加比大小，加拖拉机
    public static final int sdb2_game=2;
    //炸飞机
    public static final int zfj_game=3;
    //掷色子比大小
    public static final int bdx_game=4;
    //掷色子猜数目
    public static final int csl_game=5;
    //打台球
    public static final int dtq_game=6;

    //入口把message转为对象并找到对应执行的游戏类
    public static final String gameInfo(JSONObject json) {
        String g = "";
        switch(json.getInteger("gameId")){
            case wzq_game: // 五子棋
                g = game_wzq.exchangeData(json);
                break;
            case sdb_game: // 十点半
                g = game_wzq.exchangeData(json);
                break;
            case sdb2_game: // 十点半，加比大小，加拖拉机
                g = game_wzq.exchangeData(json);
                break;
            case zfj_game: // 炸飞机
                g = game_wzq.exchangeData(json);
                break;
            case bdx_game: // 掷色子比大小
                g = game_wzq.exchangeData(json);
                break;
            case csl_game: // 掷色子猜数目
                g = game_wzq.exchangeData(json);
                break;
            case dtq_game: // 打台球
                g = game_wzq.exchangeData(json);
                break;
            default:
                break;
        }
        return g;
    }
}
