package controllers

import play.api._
import play.api.mvc._

import net.glxn.qrgen._

import sun.misc.BASE64Encoder

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def getQR(text: String) = Action {
    Ok(qr(text))
  }

  def qr(text: String): String = {
    val base64 = new BASE64Encoder()

    val qr = QRCode.from(text).withSize(200,200)
    val bytes = qr.stream().toByteArray()

    base64.encode(bytes)
  }
}
