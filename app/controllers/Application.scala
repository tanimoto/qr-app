package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

import net.glxn.qrgen._

import sun.misc.BASE64Encoder

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def getQR(text: String) = Action {
    calculateQR(text) match {
      case Some(enc) => Ok(enc)
      case None => BadRequest
    }
  }

  // Given a string, generate QR and return in Base64
  // Note: an empty or excessively long string will return None.
  private def calculateQR(text: String): Option[String] = {
    val length = text.length
    if (0 < length && length <= 2000) {
      val base64 = new BASE64Encoder()

      val qr = QRCode.from(text).withSize(200,200)
      val bytes = qr.stream().toByteArray()

      Some(base64.encode(bytes))
    } else {
      None
    }
  }
}
