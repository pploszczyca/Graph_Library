package com.project.graph
package models

import models.GraphType._

import org.scalatest.FunSuite

class FileServiceTest extends FunSuite {
  test("File read") {
    val graph = FileService.readGraphFromFile("graphFileTest.txt", Directed)

    val edges: List[Edge] = new Edge(0,1,1) :: new Edge(0,2,0) :: new Edge(1,2,0) :: new Edge(2,4,3) :: new Edge(2,3,1) :: new Edge(3,4,0) :: Nil

    edges.foreach(edge => {
      assert(graph.hasEdge(edge) === true)
    })
  }

  test("Save file") {
    val edges: List[Edge] = new Edge(0,1,1) :: new Edge(0,2,0) :: new Edge(1,2,0) :: new Edge(2,4,3) :: new Edge(2,3,1) :: new Edge(3,4,0) :: Nil
    val graph = GraphBuilder(edges, Directed)

    FileService.saveGraphToFile(graph, "testGraph.txt")

    val readGraph = FileService.readGraphFromFile("testGraph.txt", Directed)

    edges.foreach(edge => {
      assert(readGraph.hasEdge(edge) === true)
    })

  }
}
