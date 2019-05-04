package datascience.bddev.chapter01

import java.util.Date

/**
  * Author: Khusen Sharipov
  * Date: 02/05/2019
  * Time: 16:17
  */
case class Student(name: String,
                   age: Int,
                   gender: Char,
                   admissionDate: Date,
                   faculty: String,
                   averageScore: Double,
                   hasMedal: Boolean) {
  override def toString: String = {
    name +
      " " + gender +
      " " + admissionDate +
      " " + faculty +
      " " + averageScore +
      " " + hasMedal
  }
}