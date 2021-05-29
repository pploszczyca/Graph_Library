package com.project.graph

import models.{Edge, FileService, Graph, GraphBuilder, Vertex}

import com.project.graph.models.GraphType._

object Main extends App {
  val edges = new Edge(1,2) :: new Edge(1,3) :: new Edge(1,4) :: new Edge(2,4) :: Nil

//  println(edges)

  val graph = GraphBuilder(edges, Undirected)

  FileService.saveGraphToFile(graph, "test.txt")
//
//  println(graph.hasVertex(2))
//  println(graph.hasEdge(1,2))
//  println(graph.hasEdge(2,1))

}