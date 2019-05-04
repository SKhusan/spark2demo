package datascience.chapter01

import breeze.linalg.DenseVector

/**
  * Author: Khusen Sharipov
  * Date: Март 26, 2019
  * Time: 15:43
  */
object AdvancedIndexigAndSlicing {
  def main(args: Array[String]): Unit = {
    val v = DenseVector.tabulate[Double](10) {
      _.toDouble
    }

    println(v)
    println(v(-1))
    println(v(1 to 3))
    val v1 = v(3, 5)

  }

}
