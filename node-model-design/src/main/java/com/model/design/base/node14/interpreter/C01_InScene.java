package com.model.design.base.node14.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 解释器模式
 */
public class C01_InScene {
    public static void main(String[] args) {
        DataMap dataMap = new DataMap();
        TerminalExpress terminalExpress1 = new TerminalExpress("num1");
        TerminalExpress terminalExpress2 = new TerminalExpress("num2");
        TerminalExpress terminalExpress3 = new TerminalExpress("num3");
        dataMap.putData(terminalExpress1, 1);
        dataMap.putData(terminalExpress2, 2);
        dataMap.putData(terminalExpress3, 3);
        // 1+2-3 = 0
        System.out.println(new Minus(
                           new Add(terminalExpress1,terminalExpress2), terminalExpress3)
                           .interpret(dataMap));
    }
}
// 解释器接口
interface Express {
    Integer interpret(DataMap dataMap) ;
}
// 非终结符表达式
abstract class NotTerminalExpress implements Express {
    Express express1,express2;
    public NotTerminalExpress(Express express1, Express express2){
        this.express1 = express1;
        this.express2 = express2;
    }
}
// 终结符表达式: 1+2 终结符： 1 和 2
class TerminalExpress implements Express {
    public String field ;
    public TerminalExpress (String field){
        this.field = field ;
    }
    @Override
    public Integer interpret(DataMap dataMap) {
        return dataMap.getData(this);
    }
}
// 加法表达式
class Add extends NotTerminalExpress {
    public Add (Express e1, Express e2) {
        super(e1, e2);
    }
    // 将两个表达式相减
    @Override
    public Integer interpret(DataMap context) {
        return this.express1.interpret(context) + this.express2.interpret(context);
    }
}
// 减法表达式
class Minus extends NotTerminalExpress {
    public Minus (Express e1, Express e2) {
        super(e1, e2);
    }
    // 将两个表达式相减
    @Override
    public Integer interpret(DataMap context) {
        return this.express1.interpret(context) - this.express2.interpret(context);
    }
}
// 数据容器
class DataMap {
    private Map<Express,Integer> dataMap = new HashMap<>() ;
    public void putData (Express key,Integer value){
        dataMap.put(key,value) ;
    }
    public Integer getData (Express key){
        return dataMap.get(key) ;
    }
}