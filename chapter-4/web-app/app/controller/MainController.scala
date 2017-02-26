package controller

import javax.inject.{Inject, Singleton}

import play.api.data._
import play.api.data.Forms._
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

@Singleton
class MainController @Inject()() extends Controller{
  def status= Action{
    Ok("")
  }


  case class UserData(email:String, password: String)

  val userForm = Form(
    mapping(
      "email" -> text,
      "password" -> text
    )(UserData.apply)(UserData.unapply)
  )

  def login = Action(parse.form(userForm)){implicit request =>
    val body = request.body

    Ok(
      """
        |{
        | "message" : "succes"
        |}
      """.stripMargin)
  }
}
