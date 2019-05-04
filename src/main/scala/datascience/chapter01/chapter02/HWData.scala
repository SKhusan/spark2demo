package datascience.chapter02

import breeze.linalg._
import breeze.stats._

import scala.io.Source
import scala.reflect.ClassTag

/**
  * Author: Khusen Sharipov
  * Date: Март 27, 2019
  * Time: 16:09
  */
object HWData {
  val fileName = "rep_height_weights.csv"

  def load: HWData = {
    val file = Source.fromFile(getClass.getClassLoader.getResource(fileName).getFile)
    val lines = file.getLines.toVector
    val splitLines = lines.map {
      _.split(',')
    }

    def fromList[T: ClassTag](index: Int, converter: (String => T)): DenseVector[T] =
      DenseVector.tabulate(lines.size) { irow => converter(splitLines(irow)(index)) }

    val genders = fromList(1, elem => elem.replace("\"", "").head)
    val weights = fromList(2, elem => elem.toDouble)
    val heights = fromList(3, elem => elem.toDouble)
    val reportedWeights = fromList(4, elem => elem.toDouble)
    val reportedHeights = fromList(5, elem => elem.toDouble)

    new HWData(weights, heights, reportedWeights, reportedHeights, genders)
  }
}

class HWData(val weights: DenseVector[Double],
             val heights: DenseVector[Double],
             val reportedWeights: DenseVector[Double],
             val reportedHeights: DenseVector[Double],
             val genders: DenseVector[Char]) {
  val nPoints = heights.length
  /*require(weights.length == nPoints)
  require(reportedHeights == nPoints)
  require(reportedWeights == nPoints)
  require(genders == nPoints)*/

  lazy val rescaledHeights: DenseVector[Double] = {
    (heights - mean(heights)) / stddev(heights)
  }

  lazy val rescaledWeights: DenseVector[Double] = {
    (weights - mean(weights)) / stddev(weights)
  }

  lazy val featureMatrix: DenseMatrix[Double] =
    DenseMatrix.horzcat(
      DenseMatrix.ones[Double](nPoints, 1),
      rescaledHeights.toDenseMatrix.t,
      rescaledWeights.toDenseMatrix.t
    )

  lazy val target: DenseVector[Double] =
    genders.values.map { gender => if (gender == 'M') 1.0 else 0.0 }

  override def toString: String = s"HWData [ $nPoints rows ]"

}
