package chapter01

import breeze.linalg.DenseVector

/**
  * Author: Khusen Sharipov
  * Date: Март 25, 2019
  * Time: 0:26
  */
object BreezeVectorExamples {
  def main(args: Array[String]): Unit = {
    val v = DenseVector(1.0, 2.0, 3.0)
    println(v(2))

    val v1 = v :* 2.0

    println(v1(2))

    val v2 = v :+ DenseVector(2.0, 4.5, 3.0)
    println(v2)
  }

}
