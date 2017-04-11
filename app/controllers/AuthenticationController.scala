package controllers

import com.google.inject.Inject
import helpers.Global
import play.api.mvc.{Action, Controller}

/**
  * Created by ben on 4/11/17.
  */
class AuthenticationController @Inject()(global: Global) extends Controller {
  def signup = Action {
    Ok
  }
  def login = Action {
    Ok
  }
}
