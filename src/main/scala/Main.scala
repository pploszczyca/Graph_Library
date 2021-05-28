package com.project.graph

import models.{Edge, Graph, GraphBuilder, Vertex}

import com.project.graph.database.DatabaseService
import com.project.graph.models.GraphType._

object Main extends App {
  val edges = new Edge(1,2) :: new Edge(1,3) :: new Edge(1,4) :: new Edge(2,4) :: Nil

  println(edges)

  val graph = GraphBuilder(edges, Undirected)

  println(graph.hasVertex(2))
  println(graph.hasEdge(1,2))
  println(graph.hasEdge(2,1))

//  val firstVertex = new Vertex(1, "Test1", 1)
//  val secondVertex = new Vertex(2, "Test2", 2)
//  DatabaseService.addVertex(firstVertex)
//  DatabaseService.addVertex(secondVertex)
//  DatabaseService.addEdge(firstVertex -> secondVertex)
//  DatabaseService.addVertex(new Vertex(3))
//  DatabaseService.addEdge(new Edge(1,3))
  DatabaseService.addVertex(new Vertex(4, "SampleVertex"))
  DatabaseService.addEdge(new Edge(2,4))
  DatabaseService.close()
}