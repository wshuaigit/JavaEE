package com.wangzhao.ba08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName:Main
 * Package:com.wangzhao.ba08
 * Description:
 *
 * @Date:2019/3/7 19:58
 * @Author:wangzhao
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] array = new int[n][m];
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                array[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int x = 0;
                int y = 0;
                if(x-1 >=0 && x+1 <=m && y-1>=0 && y+1<=n){
                    if(array[x-1][y]== array[x][y] && array[x+1][y]== array[x][y] && array[x][y+1]== array[x][y] && array[x][y-1]== array[x][y]){
                        sum++;
                    }
                    int t = array[x-1][y];
                    if(t == array[x-1][y] && t == array[x+1][y] && t== array[x][y+1] && t== array[x][y-1]){
                        sum++;
                    }

                }
            }
        }
        System.out.println(sum);
    }
}
