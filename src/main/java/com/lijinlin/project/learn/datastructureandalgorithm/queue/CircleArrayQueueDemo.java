package com.lijinlin.project.learn.datastructureandalgorithm.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //设置4实际有效空间是3
        CircleArray arrayQueue = new CircleArray(4);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列去除数据");
            System.out.println("h(head):查看队列头的数据");
            //接受一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    //取数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头的数据
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArray {
    //数组最大容量
    private int maxSize;
    //队列头指向第一个元素 默认是0
    private int front;
    //队列尾指向最后一个元素后一个位置 默认是0
    private int rear;
    //模拟队列存放数据
    private int[] arr;

    //创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        //环形队列
        return (rear + 1) % maxSize == 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据");
            return;
        }
        arr[rear] = n;
        //让rear后移,这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取出队列的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取到数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1先把front对应的值保留到一个临时变量
        int temp = arr[front];
        //2将front后移
        front = (front + 1) % maxSize;
        //3将临时保存的变量返回
        return temp;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的~~");
            return;
        }
        //从front开始便利，便利多少个元素
        int size = size();
        for (int i = front; i < front + size; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front];
    }
}
