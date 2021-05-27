package com.project.graph

import models.{Edge, Graph, GraphBuilder}
import com.project.graph.models.GraphType._

object Main extends App {
  val edges = new Edge[Int](1,2) :: new Edge[Int](1,3) :: new Edge[Int](1,4) :: new Edge[Int](2,4) :: Nil

  println(edges)

  val graph = GraphBuilder(edges, Undirected)

  println(graph.hasVertex(1))
  println(graph.hasEdge(1,2))
  println(graph.hasEdge(2,1))

}