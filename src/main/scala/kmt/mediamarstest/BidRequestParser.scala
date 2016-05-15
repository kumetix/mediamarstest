package kmt.mediamarstest

import kmt.mediamarstest.BidRequestParser.BidRequest
import play.api.libs.json.{JsValue, Json}

/**
 * Created by assafe on 5/15/2016.
 */
class BidRequestParser {
  def parse(rawJson: String) = {
    val jsValue: JsValue = Json.parse(rawJson)
    val id = (jsValue \ "id").as[String]
    val userAgent = (jsValue \ "device" \ "ua").as[String]
    BidRequest(id, userAgent)
  }
}

object BidRequestParser {
  case class BidRequest(reqId: String, userAgent: String)
  def apply() = new BidRequestParser
}

