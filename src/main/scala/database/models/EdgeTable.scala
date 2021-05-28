package com.project.graph
package database.models

import com.project.graph.models.Edge
import slick.lifted.Tag
import slick.jdbc.SQLiteProfile.api._



class EdgeTable(tag: Tag) extends Table[(Int, Int, Int, Double)](tag, "Edge"){
  lazy val vertexes = TableQuery[VertexTable]

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def value = column[Double]("value")
  def fromVertexID = column[Int]("fromVertexID")
  def toVertexID = column[Int]("toVertexID")

  def * = (id, fromVertexID, toVertexID, value)

  def fromVertex = foreignKey("fromVertex", fromVertexID, vertexes)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def toVertex = foreignKey("toVertex", toVertexID, vertexes)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

}
