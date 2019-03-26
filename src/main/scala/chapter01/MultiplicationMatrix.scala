package chapter01

import breeze.linalg.DenseMatrix

/**
  * Author: Khusen Sharipov
  * Date: Март 26, 2019
  * Time: 16:18
  */
object MultiplicationMatrix {
  def main(args: Array[String]): Unit = {
    val m1 = DenseMatrix((2.0, 3.5, 4.1), (1.5, 3.9, 6.2), (5.1, 0.5, 1.8))
    println(m1)
    val m2 = DenseMatrix((1.3, 2.9, 3.1), (1.3, 1.8, 6.5))
    println(m2)
  }
}
