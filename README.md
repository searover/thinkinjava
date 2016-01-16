# thinkinjava
Exercises from the book "**Think in Java**"

1, Java SE5 引入了一种新的更加简洁的for语法用于数组和容器，即foreach语法，表示不必创建int变量去对由访问项构成的序列进行计数，foreach将自动产生每一项。

2，无穷循环的第二种形式是for(;;)，编译器将while(true)和for(;;)看作是同一回事，所以具体选用哪个取决于自己的编程习惯。

3，编程语言中一开始就有goto关键词了。事实上，goto起源于汇编语言的程序控制，如果阅读由编译器最终生成的汇编代码，就会发现程序控制里包含很多跳转。（Java编译器生成它自己的“汇编代码”，但是这个代码是运行在Java虚拟机上的，而不是直接运行在CPU硬件上）。

4，需要记住的重点是：在Java里需要使用标签的唯一理由就是因为有循环嵌套存在，而且想从多层嵌套中break或continue。

5，关于Java构造器：尽管可以用this调用一个构造器，但不能调用两次，此外，必须将构造器调用置于最起始处，否则编译器会报错，另外，除了构造器外，编译器禁止在其他任何方法中调用构造器。

6，在static方法内部并不是不可调用非静态方法，如果你传递一个对象的引用到静态方法里（静态方法可以创建其自身的对象），然后通过这个引用，你就可以调用非静态方法和访问非静态数据。

7，清理，垃圾回收：假定你的对象（并非使用new）获得一块“特殊”的内存区域，由于垃圾回收器只知道释放那些经由new分配的内存，所以它不知道该如何释放该对象的这块内存。为了应对这种情况，Java允许在类中定义一个名为finalize()的方法。它的工作原理假定是这样的：一旦一旦垃圾回收器准备好释放对象占用的存储空间，将首先调用其finalize()方法，并且在下一次垃圾回收动作发生时，才会真正回收对象占用的内存。所以要是你打算用finalize()，就能在垃圾回收时刻做一些重要的清理工作。

8，之所以要有finalize()方法，是由于分配内存时可能采用了类似C语言中的做法，而非Java中的通常做法。这种情况主要发生在使用“本地方法”的情况下，本地方法是在Java中调用非Java代码的方式。本地方法目前只支持C和C++，但它们可以调用其他语言写的代码。在非Java代码中，也许会调用C的malloc()函数系列来分配内存，而且除非用了free()函数，否则存储空间将得不到释放，从而造成内存泄露。当然，free()是C和C++中的函数，所以需要在finalize()中用本地方法调用它。


9，不要过多的使用finalize()方法，它无法预料，常常是危险的，它确实不是进行普通的清理工作的合适场所。无论是垃圾回收，还是“终结finalize”，都不保证一定会发生。如果Java虚拟机并未面临耗尽内存的情形，它是不会浪费时间去执行垃圾回收以恢复内存的。

10，在以前用过的程序语言中，在堆上分配对象的代价十分昂贵，因此读者自然会觉得Java中所有对象（基本类型除外）都在堆上分配的方式也非常高昂。然而，垃圾回收器对于提高对象的创建速度，却具有明显的效果。听起来很奇怪-- 存储空间的释放竟然会影响存储空间的分配，但这确实是某些Java虚拟机的工作方式。这也意味着，Java从堆分配空间的速度，可以和其他语言从堆栈上分配空间的速度相媲美。

11，在某些Java虚拟机中，堆的实现更像一个传送带，每分配一个对象，它就往前移动一格。这意味着对象的存储空间的分配非常快。Java的“堆”指针只是简单的移动到尚未分配的区域，其效率比得上C++在堆栈上分配空间的效率。但Java的堆未必完全像传送带那样工作，要真是那样的话，会导致频繁的内存页面调度--将其移进移出硬盘，因此会显得需要拥有比实际需要更多的内存。页面调度会显著影响性能，最终，在创建了足够多的对象之后，内存资源将耗尽。其中的秘密就在于垃圾回收器的介入。当它工作时，将一面回收空间，一面使堆中的对象紧凑排列，这样“堆指针”就可以很容易的移动到更靠近传送带开始的地方，也就尽量避免了页面错误，通过垃圾回收器对对象重新排列，实现了一种高速的，有无限空间可供分配的堆模型。

12，Java尽力保证：所有变量在使用前都能得到恰当的初始化，对于方法的局部变量，Java以编译时错误的形式来贯彻这种保证。要是类的灵气成员（即字段）是基本类型，情况就会变得有些不同，类的每个基本类型数据成员保证都会有一个初始值。
