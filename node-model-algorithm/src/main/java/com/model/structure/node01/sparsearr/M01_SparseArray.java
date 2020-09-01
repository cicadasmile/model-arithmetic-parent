package com.model.structure.node01.sparsearr;

public class M01_SparseArray {
    public static void main(String[] args) {
        // 棋盘：基于二维数组
        int chessArray[][] = printChess () ;
        System.out.println("==========================");
        // 二维数组转稀疏数组
        int sparseArray[][] = convertTwoArray(chessArray) ;
        System.out.println("==========================");
        // 稀疏数组转二维数组
        convertSparseArray(sparseArray);
    }

    /**
     * 基于二维数组生成棋盘
     */
    public static int[][] printChess (){
        // 二维数组表示 11 * 11 的棋盘，0表示没有棋,1表示 黑, 2 表示蓝
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return chessArray ;
    }

    /**
     * 二维数组转稀疏数组
     */
    public static int[][] convertTwoArray (int chessArray[][]){
        // 有效元素：先遍历二维数组 得到非0数据的个数
        int unZeroSum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    unZeroSum++;
                }
            }
        }
        // 行：有效元素+1，列：3列
        int sparseArray[][] = new int[unZeroSum+1][3] ;
        sparseArray[0][0] = 11 ;// 0行0列值：11
        sparseArray[0][1] = 11 ;// 0行1列值：11
        sparseArray[0][2] = unZeroSum ;// 0行2列值：unZeroSum

        // 遍历二维数组，将非0的值存放到稀疏数组中
        // unZeroCount 用于记录是第几个非0数据,也就是稀疏数组的行
        int unZeroCount = 0; //
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    unZeroCount++;
                    sparseArray[unZeroCount][0] = i;
                    sparseArray[unZeroCount][1] = j;
                    sparseArray[unZeroCount][2] = chessArray[i][j];
                }
            }
        }
        // 输出稀疏数组的形式
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArray[i][0],
                    sparseArray[i][1],
                    sparseArray[i][2]);
        }
        return sparseArray ;
    }

    /**
     * 稀疏数组转二维数组
     */
    public static void convertSparseArray (int sparseArray[][]){
        // 读取稀疏数组首行创建二维数组==>> int chessArray[][] = new int[11][11];
        int chessArray[][] = new int[sparseArray[0][0]][sparseArray[0][1]] ;
        // 非零元素赋值给二维数组
        for(int i = 1; i < sparseArray.length; i++) {
            // 几行、几列、是什么值
            chessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 打印二维数组
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
