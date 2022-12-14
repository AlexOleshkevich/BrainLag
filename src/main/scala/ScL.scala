object ScL {

  sealed trait List[+A]

  object Nil extends List[Nothing]
  case class Cons[A](head: A, tail: List[A]) extends List[A]

  object List {

    def sum(ints: List[Int]): Int = ints match {
      case Nil => 0
      case Cons(x, y) => x + sum(y)
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1
      case Cons(d, ds) => d * product(ds)
    }

    def apply[A](as: A*): List[A] = {
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))
    }

    def tail[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(_, t) => t
    }

    def setHead[A](l: List[A], v: A): List[A] = l match {
      case Nil => Cons(v, Nil)
      case Cons(x, t) => Cons(v, t)
    }

    def drop[A](l: List[A], n: Int): List[A] = l match {
      case Nil => Nil
      case Cons(x, t) =>
        if (n <= 0) l
        else drop(t, n - 1)
    }

    def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
      case Nil => Nil
      case Cons(x, t) =>
        if (f(x)) dropWhile(t, f)
        else l
    }

    def init[A](l: List[A]): List[A] = l match {
      case Nil => Nil
      case Cons(x, t) => Cons(x, init(t))
    }
  }

  def main(args: Array[String]): Unit = {
    val list1 = List(1,2,3,4)
  }

}
