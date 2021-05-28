package com.project.graph
package database

import com.project.graph.database.models.{EdgeTable, VertexTable}
import com.project.graph.models.{Edge, Vertex}
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object DatabaseService {
  val db = Database.forConfig("graphDB")
  val vertexes = TableQuery[VertexTable]
  val edges = TableQuery[EdgeTable]

  val setup = DBIO.seq(
    (vertexes.schema ++ edges.schema).create
  )

  val setupFuture = db.run(setup)

  def addVertex(vertex: Vertex): Unit = {
    Await.result(db.run(DBIO.seq(
      vertexes += (vertex.id, vertex.name, vertex.value)
    )), Duration.Inf)
  }

  def addEdge(edge: Edge): Unit = {
    Await.result(db.run(DBIO.seq(
      edges += (1, edge.fromVertex.id, edge.toVertex.id, edge.value)
    )), Duration.Inf)
  }

  def close(): Unit = {
    db.close()
  }
}
