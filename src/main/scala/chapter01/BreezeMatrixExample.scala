package chapter01

import breeze.linalg.DenseMatrix

/**
  * Author: Khusen Sharipov
  * Date: Март 25, 2019
  * Time: 0:42
  */
object BreezeMatrixExample {
  def main(args: Array[String]): Unit = {
    val m = DenseMatrix((1.3, 2.9, 1.5), (0.8, 2.3, 1.5), (1.7, 2.3, 0.3))
    println(m)

    println()
    println()
    println(m.cols)
    println(m.rows)
    println()
    println()
    val m1 = m :* 2.0
    println(m1)
    println()
    println()

    val m2 = DenseMatrix.tabulate[Double](3, 3) {
      (irow, icol) => irow * 1.2 + icol
    }
    println(m2)
    println()
    println()
    val m3 = DenseMatrix.rand(3, 4)
    println(m3 :* 2.0)

  }

}
