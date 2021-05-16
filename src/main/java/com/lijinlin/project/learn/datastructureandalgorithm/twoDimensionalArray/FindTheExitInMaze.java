package com.lijinlin.project.learn.datastructureandalgorithm.twoDimensionalArray;

public class FindTheExitInMaze {
    /**
     * 在一个迷宫中小球从坐标（1,1）开始一直走，走到（6,5）为终点
     * （0，？）（？，0）第0行，0列是墙不能走
     * （7，？）（？，6）第7行，6列是墙不能走
     * 0表示当前节点没有走过
     * 1表示当前节点是墙
     * 2表示当前节点通路已经找到
     * 3表示当前节点已经走过是死路
     */
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //1新建地图地图边缘用1来表示
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 || i == 7 || j == 0 || j == 6) {
                    //这些位置都是墙壁所以设置为1
                    map[i][j] = 1;
                }else{
                    //不是墙壁，设置为0;
                    map[i][j] = 0;
                }
            }
        }
        System.out.println("输出地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void setWay(int[][] map,int i,int j){

    }

}
