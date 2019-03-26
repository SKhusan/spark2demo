package chapter01

import breeze.linalg.DenseVector

/**
  * Author: Khusen Sharipov
  * Date: Март 26, 2019
  * Time: 15:55
  */
object MutatingVectorAmdMatrix {
  def main(args: Array[String]): Unit = {
    val v = DenseVector(1.0, 4.0, 9, 1)
    v(1) = 12.5
    println(v)

    val v100 = DenseVector.tabulate(100) {
      _.toDouble
    }
    val vEvens = v100(0 until v100.length by 2)
    println(vEvens)
  }
}
