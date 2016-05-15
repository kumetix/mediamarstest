package kmt.mediamarstest

import java.io.InputStream

import kmt.mediamarstest.BidRequestParser.BidRequest

import scala.io.Source

/**
 * Created by assafe on 5/15/2016.
 */
object Application extends App {
  override def main(args: Array[String]) {
    val stream: InputStream = getClass.getResourceAsStream("/bidRequest0.json")
    val bidReqRawJson: String = Source.fromInputStream(stream).mkString
    val bidRequest: BidRequest = BidRequestParser().parse(bidReqRawJson)
    println(s"bid request id: ${bidRequest.reqId}")
    println(s"bid request useragent: ${bidRequest.userAgent}")
  }
}
