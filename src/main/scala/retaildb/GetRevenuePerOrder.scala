package retaildb

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Author: Khusen Sharipov
  * Date: Март 19, 2019
  * Time: 23:38
  */
object GetRevenuePerOrder {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster(args(0))
      .setAppName("get revenue app")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val orderItems = sc.textFile(args(1))
    val revenuePerOrder = orderItems
      .map(str => (str.split(",")(1).toInt, str.split(",")(4).toFloat))
      .reduceByKey(_ + _)
      .map(oi => oi._1 + ", " + oi._2)
    revenuePerOrder.saveAsTextFile(args(2))
  }
}
