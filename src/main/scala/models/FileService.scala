package com.project.graph
package models

import models.GraphType.GraphType

import java.io.{File, PrintWriter}

object FileService {
  def readGraphFromFile(path: String, graphType: GraphType): TGraph = {
    val inFile = scala.io.Source.fromFile(path)
    var edges = List[Edge]()

    for(line <- inFile.getLines()) {
      val values: List[Int] = line.split(" ").map(_.toInt).toList
      edges = new Edge(values(0), values(1), values(2).toDouble) :: edges
    }

    inFile.close()

    GraphBuilder(edges, graphType)
  }

  def saveGraphToFile(graph: TGraph, resultPath: String): Unit = {
    val outFile = new PrintWriter(new File(resultPath))
    graph.getVertexesIDs().flatMap(graph.getEdgesForVertex(_).toList).foreach(edge => outFile.println(edge.fromVertex.id.toString + " " + edge.toVertex.id.toString + " " + edge.value.toInt.toString))
    outFile.close()
  }
}
