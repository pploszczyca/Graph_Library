package com.project.graph
package algorithms

import com.project.graph.models.GraphType.{Directed, Undirected}
import com.project.graph.models.{Edge, GraphBuilder}
import org.scalatest.FunSuite

class EulerTest extends FunSuite {
  test("Is Euler") {
    assert(Euler.isEulerian(GraphBuilder(new Edge(1,0) :: new Edge(0,2) :: new Edge(2,1) :: new Edge(0,3) :: new Edge(3,4) :: Nil, Undirected)) === false)
    assert(Euler.isEulerian(GraphBuilder(new Edge(1,0) :: new Edge(0,2) :: new Edge(2,1) :: new Edge(0,3) :: new Edge(3,4) :: new Edge(4,0) :: Nil, Undirected)) === true)
    assert(Euler.isEulerian(GraphBuilder(new Edge(1,0) :: new Edge(0,2) :: new Edge(2,1) :: new Edge(0,3) :: new Edge(3,4) :: new Edge(1,3) :: Nil, Undirected)) === false)
  }

  test("Euler list") {
   assert(Euler.eulerCicle(GraphBuilder(new Edge(0,1) :: new Edge(0,2) :: new Edge(1,2) :: new Edge(2,3) :: new Edge(2,4) :: new Edge(3,4) :: Nil, Undirected)) === List[Int](0,2,4,3,2,1,0))
  }

}
