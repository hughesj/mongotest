package controllers

import play.api._
import play.api.mvc._
import reactivemongo.api._
import reactivemongo.bson._
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.iteratee.Iteratee
import scala.concurrent.Future
import models._
import org.joda.time.DateTime




object Application extends Controller {
  
  val driver = new MongoDriver
  val connection = driver.connection(List("localhost"))
  val db = connection("testdatabase")
  val collection = db("testtabel")
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
    
  }
  
  def saveTestData(title: String) = Action {
	  
	  
    Ok(views.html.index("this would save"))
    
  }
 
  
  
  
  
}
  

