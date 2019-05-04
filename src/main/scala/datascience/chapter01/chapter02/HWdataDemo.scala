package datascience.chapter01.chapter02

import breeze.linalg.DenseVector
import datascience.chapter02.HWData

/**
  * Author: Khusen Sharipov
  * Date: Март 27, 2019
  * Time: 16:50
  */
object HWdataDemo {
  def main(args: Array[String]): Unit = {
    //println(HWData.load.rescaledHeights)
    /*val lines = Source.fromFile(getClass.getClassLoader.getResource("rep_height_weights.csv").getFile).getLines()
    println(lines.length)*/
    val data = HWData.load
    val maleVector = DenseVector.fill(data.genders.length)('M')
    val isMale = (data.genders :== maleVector)
    //println(isMale)

    val maleHeigths = data.heights(isMale)
    println(maleHeigths.toDenseVector)
  }
}
