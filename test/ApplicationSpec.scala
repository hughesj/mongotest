package test

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._



import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import org.scalatest.OptionValues._
import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Result
import controllers.Application
/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends WordSpec with MustMatchers {
  
  "Application" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        route(FakeRequest(GET, "/boum")) must be(None)        
      }
    }
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must be(OK)
        //contentType(home) must beSome.which(_ == "text/html")
        //contentAsString(home) must contain ("Your new application is ready.")
      }
    }
  }
}