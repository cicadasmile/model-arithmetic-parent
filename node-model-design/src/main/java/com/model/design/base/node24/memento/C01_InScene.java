package com.model.design.base.node24.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * 备忘录模式应用场景
 */
public class C01_InScene {
    public static void main(String[] args) {
        Record record = new Record() ;
        Player player = new Player() ;
        PlayData pd1 = new PlayData("西游记","19:19") ;
        PlayData pd2 = new PlayData("红楼梦","29:19") ;
        player.setPlayData(pd1);
        player.saveProgress() ;
        System.out.println("正在播放："+
                player.getPlayData().getVideoName()+":"+
                player.getPlayData().getPlayTime());
        record.put(new Progress(pd1));
        System.out.println("===切换播放视频===");
        player.setPlayData(pd2);
        player.saveProgress() ;
        System.out.println("正在播放："+
                player.getPlayData().getVideoName()+":"+
                player.getPlayData().getPlayTime());
        record.put(new Progress(pd1));
        System.out.println("===切回上个视频===");
        player.resumeProgress(record.get(pd1.getVideoName()));
        System.out.println("正在播放："+
                player.getPlayData().getVideoName()+":"+
                player.getPlayData().getPlayTime());
    }
}
/**
 * 视频播放器
 */
class Player {
    private PlayData playData ;
    public PlayData getPlayData() {
        return playData;
    }
    public void setPlayData(PlayData playData) {
        this.playData = playData;
    }
    public Progress saveProgress (){
        return new Progress(playData) ;
    }
    public void resumeProgress (Progress progress){
        playData = progress.getPlayData() ;
    }
}
/**
 * 播放进度
 */
class Progress {
    private PlayData playData ;
    public Progress (PlayData playData){
        this.playData = playData ;
    }
    public PlayData getPlayData() {
        return playData ;
    }
}
/**
 * 播放记录
 */
class Record {
    private Map<String,Progress> dataMap = new HashMap<>() ;
    public void put (Progress progress){
        dataMap.put(progress.getPlayData().getVideoName(),progress) ;
    }
    public Progress get (String videoName){
        return dataMap.get(videoName) ;
    }
}
/**
 * 播放状态描述
 */
class PlayData {
    private String videoName ;
    private String playTime ;
    public PlayData(String videoName, String playTime) {
        this.videoName = videoName;
        this.playTime = playTime;
    }
    public String getVideoName() {
        return videoName;
    }
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
    public String getPlayTime() {
        return playTime;
    }
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
}