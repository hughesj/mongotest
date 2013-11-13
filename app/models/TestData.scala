package models

import org.jboss.netty.buffer._
import org.joda.time.DateTime
import play.api.data._
import play.api.data.format.Formats._
import play.api.data.validation.Constraints._

import reactivemongo.bson._

case class TestData(
  id: Option[BSONObjectID],
  title: String,
  creationDate: Option[DateTime])

object TestData {
  implicit object ArticleBSONReader extends BSONDocumentReader[TestData] {
    def read(doc: BSONDocument): TestData =
      TestData(
        doc.getAs[BSONObjectID]("_id"), 
        doc.getAs[String]("title").get,
        doc.getAs[BSONDateTime]("creationDate").map(dt => new DateTime(dt.value)))
  }
  
  implicit object ArticleBSONWriter extends BSONDocumentWriter[TestData] {
    def write(test: TestData): BSONDocument =
      BSONDocument(
        "_id" -> test.id.getOrElse(BSONObjectID.generate),
        "title" -> test.title,
        "creationDate" -> test.creationDate.map(date => BSONDateTime(date.getMillis)))
  }
  
}