package com.project.graph

import models.Graph

object Main extends App {
  var graph = new Graph[Int]()

  graph.addVertex(1)
  graph.addVertex(2)

  println(graph.hasVertex(1))
  println(graph.hasVertex(3))

  print(graph.toString)

//  var tmpMap = Map(1 -> "Test")
//  println(tmpMap get 1)
//  println(tmpMap get 2)

}