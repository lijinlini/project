package com.lijinlin.project.learn.dataStructureAndAlgorithm.twoDimensionalArray;

public class FindTheExitInMaze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //1新建地图地图边缘用1来表示
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 || i == 7 || j == 0 || j == 6) {
                    //这些位置都是墙壁所以设置为1
                    map[i][j] = 1;
                } else {
                    //不是墙壁，设置为0;
                    map[i][j] = 0;
                }
            }
        }
        /*System.out.println("输出地图:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }*/

        setWayURDL(map, 1, 1);

        System.out.println("输出路径:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 在一个迷宫中小球从坐标（1,1）开始一直走，走到（6,5）为终点
     * （0，？）（？，0）第0行，0列是墙不能走
     * （7，？）（？，6）第7行，6列是墙不能走
     * 0表示当前节点没有走过
     * 1表示当前节点是墙
     * 2表示当前节点通路已经找到
     * 3表示当前节点已经走过是死路
     * <p>
     * (i,j)是当前走到的点
     */
    public static Boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明已经走到终点了
            return true;
        } else {
            //当前节点没有走过
            if (map[i][j] == 0) {
                //先假设当前节点可以走
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    //往上走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //往右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //往下走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //往左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //当前节点走过了就返回false
                return false;
            }
        }

    }


    /**
     * 修改找路策略，改成上右下左
     *
     * @param map
     * @param i
     * @param j
     * @return java.lang.Boolean
     * @author lijinlin
     * @date 2021/6/2 9:25
     */
    public static Boolean setWayURDL(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明已经走到终点了
            return true;
        } else {
            //当前节点没有走过
            if (map[i][j] == 0) {
                //先假设当前节点可以走
                map[i][j] = 2;
                if (setWayURDL(map, i - 1, j)) {
                    //往上走
                    return true;
                } else if (setWayURDL(map, i, j + 1)) {
                    //往右走
                    return true;
                } else if (setWayURDL(map, i + 1, j)) {
                    //往下走
                    return true;
                } else if (setWayURDL(map, i, j - 1)) {
                    //往左走
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //当前节点走过了就返回false
                return false;
            }
        }

    }

}
