package com.project.graph

import algorithms._
import models.GraphType._
import models.{Edge, FileService, GraphBuilder}

object Main extends App {
  val edges = new Edge(1,0) :: new Edge(0,2) :: new Edge(2,1) :: new Edge(0,3) :: new Edge(3,4) :: new Edge(4,0) :: Nil

  val graph = GraphBuilder(edges, Undirected);

  println("EXAMPLES:")
  println("BFS - " + BFS(graph, 0))
  println("DFS - " + BFS(graph, 0))
  println("Dijkstra - " + Dijkstra(graph, 1, 4))
  println("is Eulerian - " + Euler.isEulerian(graph))
  println("Eulerian - " + Euler.eulerCicle(graph))


  FileService.saveGraphToFile(graph, "test.txt")
}