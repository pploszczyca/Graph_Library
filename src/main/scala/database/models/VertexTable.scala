package com.project.graph
package database.models

import slick.lifted.Tag
import slick.jdbc.SQLiteProfile.api._

class VertexTable(tag: Tag) extends Table[(Int, String, Double)](tag, "Vertex"){
  def id = column[Int]("ID", O.PrimaryKey)
  def name = column[String]("name")
  def value = column[Double]("value")

  def * = (id, name, value)
}
