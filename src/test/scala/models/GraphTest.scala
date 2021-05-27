package com.project.graph
package models

import org.scalatest.FunSuite

class GraphTest extends FunSuite {
  test("Add Vertex test") {
    val graph = new Graph[Int]
    graph.addVertex(1)
    graph.addVertex(2)

    assert(graph.hasVertex(1) === true)
    assert(graph.hasVertex(2) === true)
    assert(graph.hasVertex(3) === false)

    graph.addVertex(3)
    assert(graph.hasVertex(3) === true)
  }

  test("Remove Vertex and vertexes amount test") {
    val graph = new Graph[Int]

    assert(graph.getVertexesAmount() === 0)

    graph.addVertex(1)
    graph.addVertex(2)
    graph.addEdge(1, 2)

    assert(graph.hasVertex(1) === true)
    assert(graph.hasVertex(2) === true)
    assert(graph.hasEdge(1,2) === true)
    assert(graph.getVertexesAmount() === 2)

    graph.removeVertex(2)

    assert(graph.hasVertex(1) === true)
    assert(graph.hasVertex(2) === false)
    assert(graph.hasEdge(1,2) === false)
    assert(graph.getVertexesAmount() === 1)

    graph.removeVertex(1)

    assert(graph.hasVertex(1) === false)
    assert(graph.hasVertex(2) === false)
    assert(graph.getVertexesAmount() === 0)

    graph.addVertex(1)
    assert(graph.hasVertex(1) === true)
    assert(graph.getVertexesAmount() === 1)
  }

  test("Add edge test") {
    val graph = new Graph[Int]

    // Before adding edges
    assert(graph.hasVertex(1) === false)
    assert(graph.hasVertex(2) === false)
    assert(graph.hasVertex(3) === false)

    assert(graph.hasEdge(1,2) === false)
    assert(graph.hasEdge(2,3) === false)
    assert(graph.hasEdge(3,1) === false)

    // Adding edges
    graph.addEdge(new Vertex[Int](1) -> new Vertex[Int](2))
    graph.addEdge(new Vertex[Int](2) -> new Vertex[Int](3))
    graph.addEdge(new Vertex[Int](3) -> new Vertex[Int](1))

    // After adding edges
    assert(graph.hasVertex(1) === true)
    assert(graph.hasVertex(2) === true)
    assert(graph.hasVertex(3) === true)

    assert(graph.hasEdge(1,2) === true)
    assert(graph.hasEdge(2,3) === true)
    assert(graph.hasEdge(3,1) === true)

    assert(graph.hasEdge(2,1) === false)
    assert(graph.hasEdge(3,2) === false)
    assert(graph.hasEdge(1,3) === false)


    graph.addEdge(4,5)
    assert(graph.hasVertex(4) === true)
    assert(graph.hasVertex(5) === true)

    assert(graph.hasEdge(4,5) === true)
    assert(graph.hasEdge(5,4) === false)
  }

  test("Remove edge test") {
    val graph = new Graph[Int]
    graph.addEdge(new Vertex[Int](1) -> new Vertex[Int](2))
    graph.addEdge(new Vertex[Int](2) -> new Vertex[Int](3))
    graph.addEdge(new Vertex[Int](3) -> new Vertex[Int](1))

    assert(graph.hasEdge(1,2) === true)
    assert(graph.hasEdge(2,3) === true)
    assert(graph.hasEdge(3,1) === true)

    graph.removeEdge(1,2)
    assert(graph.hasEdge(1,2) === false)
    assert(graph.hasEdge(2,3) === true)
    assert(graph.hasEdge(3,1) === true)

    graph.removeEdge(new Edge[Int](2,3))
    assert(graph.hasEdge(1,2) === false)
    assert(graph.hasEdge(2,3) === false)
    assert(graph.hasEdge(3,1) === true)

    graph.addEdge(2,3)
    assert(graph.hasEdge(1,2) === false)
    assert(graph.hasEdge(2,3) === true)
    assert(graph.hasEdge(3,1) === true)
  }

  test("Get vertex test") {
    val graph = new Graph[String]
    val vertex = new Vertex[String](1)

    graph.addVertex(vertex)
    assert(vertex === graph.getVertex(1))

    assert(graph.getVertex(2) === null)
  }

  test("Get Edges for Vertex test") {
    val graph = new Graph[String]
    graph.addEdge(1,2)
    graph.addEdge(1,3)
    graph.addEdge(2,3)
    graph.addVertex(4)

    var edgesOfVertexOne = graph.getEdgesForVertex(1)

    assert((edgesOfVertexOne contains new Edge[String](1,2)) === true)
    assert((edgesOfVertexOne contains new Edge[String](1,3)) === true)
    assert((edgesOfVertexOne contains new Edge[String](2,3)) === false)
    assert((edgesOfVertexOne contains new Edge[String](1,4)) === false)

    graph.removeEdge(1,2)
    edgesOfVertexOne = graph.getEdgesForVertex(1)
    assert((edgesOfVertexOne contains new Edge[String](1,2)) === false)
    assert((edgesOfVertexOne contains new Edge[String](1,3)) === true)
  }
}
