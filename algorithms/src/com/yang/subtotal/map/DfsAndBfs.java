package com.yang.subtotal.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DfsAndBfs {
    /*
    * DFS图的深度遍历
    * 邻接矩阵存贮
    * 类似于树的先序遍历
    * */
    public void dfs(HashMap<Character,LinkedList<Character>> graph,HashMap<Character,Boolean> visited,Character v){
        visited.put(v,true);
        //visite(v); //访问节点
        LinkedList<Character> linkedList = graph.get(v);
        for (Character node : linkedList) {
            if(!visited.containsKey(node)){
                dfs(graph,visited,node);
            }
        }
    }

    /*
    * BFS图的广度遍历
    * 邻接矩阵存储
    * 类似于树的层次遍历
    * */
    public void bfs(HashMap<Character,LinkedList<Character>> graph,HashMap<Character,Boolean> visited,Character v){
        Queue<Character> queue = new LinkedList<>();
        Character top;
        visited.put(v,true);
        //visite(v); 访问节点
        queue.add(v);
        while(!queue.isEmpty()){
            top = queue.poll();
            LinkedList<Character> list = graph.get(top);
            for (Character node : list) {
                if(!visited.containsKey(node)){
                    visited.put(node,true);
                    //visite(node); 访问节点
                    queue.add(node);
                }
            }
        }
    }
}
