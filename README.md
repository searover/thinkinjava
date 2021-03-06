# thinkinjava
Exercises from the book "**Think in Java**"

1, Java SE5 引入了一种新的更加简洁的for语法用于数组和容器，即foreach语法，表示不必创建int变量去对由访问项构成的序列进行计数，foreach将自动产生每一项 。

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

13，总结一下对象创建的过程，假设有个名为Dog的类：
    1，即使没有显式的使用static关键字，构造器实际上也是静态方法。因此，当首次创建类型为Dog的对象时，或者Dog的静态方法/静态域首次被访问时，Java解释器必须查找类路径，以定位Dog.class文件。
    2，然后载入Dog.class，有关静态初始化的所有动作都会执行。因此，静态初始化只在Class对象首次加载的时候进行一次。
    3，当用new Dog()创建对象的时候，首先将在堆上为Dog对象分配足够的存储空间。
    4，这块存储空间会被清零，这就自动地将Dog对象中的所有基本类型数据都设置成了默认值，而引用则被设置成了null。
    5，执行所有出现于字段定义处的初始化动作。
    6，执行构造器，这可能会牵涉到很多动作，尤其是涉及继承的时候。
 
14，实例初始化子句与静态初始化子句一模一样，只不过少了static关键字。这种语法对于支持“匿名内部类”的初始化是必须的，但是它也使得你可以保证无论调用了哪个显式的构造器，某些操作都会发生。

15，所有数组（无论它们的元素是对象还是基本类型）都有一个固有成员，可以通过它获知数组内包含多少个元素，但不能对其修改，这个成员就是length。

16，class [I 前导的"["表示这是一个后面紧随的类型的数组，而紧随的“I”表示基本类型int

17，你应该总是只在重载方法的一个版本上使用可变参数列表，或者压根就不用它。

18，在Java SE5中添加了一个看似很小的特性，即enum关键字，它使得我们在需要群组并使用枚举类型集时，可以很方便的处理。由于枚举类型的实例是常量，因此按照命名惯例它们都用大写字母表示（如果在一个名字中有多个单词，用下划线将他们隔开）。

19，Java的垃圾回收器极大的简化了编程工作，而且在处理内存方面也更安全。然而，垃圾回收器确实也增加了运行时的开销，而且Java解释器从来就很慢，所以这种开销到底造成多大的影响也很难看出。随着时间的推移，Java在性能方面已经取得长足进步，但在速度总是上仍然是它涉足某些特定编程领域的障碍。

20，访问权限控制的等级，从最大权限到最小权限依次为：public、protected、包访问权限（没有关键词）和private。

21，当编写一个Java源代码文件时，此文件通常被称为编译单元（有时也被称为转译单元）。每一个编译单元都必须有一个后缀名.java，而在编译单元内则可以有一个public类，该类的名称必须与文件的名称相同（包括大小写，但不包括文件的后缀名.java）。每一个编译单元只能有一个public类，否则编译器就不会接受。如果在该编译单元之中还有额外的类的话，那么在包之外的世界是无法看见这些类的，这是因为它们不是public类，而且它们主要用来为主public类提供支持。

22，Java可运行程序是一组可以打包并压缩为一个Java文档文件（JAR，使用Java的jar文档生成器）的.class文件。Java解释器负责这些文件的查找、装载和解释。

23，Java解释器的运行过程如下：首先，找出环境变量CLASSPATH，CLASSPATH包含一个或多个目录，用作查找.class文件的根目录。从根目录开始，解释器获取包的名称，并将每个句点换成反斜杠，以从CLASSPATH根中产生一个路径名称。得到的路径会与CLASSPATH中的各个不同的项相连接，解释器就在这些目录中查找与你所要创建的类名称相关的.class文件（解释器还会去查找某些涉及Java解释器所在位置的标准目录）。

24，对使用Java的新手来说，设置CLASSPATH是很麻烦的一件事，为些，Sun将Java2中的JDK改造得更聪明了一些。在安装后你会发现，即使你未设立CLASSPATH，你也可以编译并运行基本的Java程序。

25，提供访问器（accessor）和变异器（mutator）方法（也称作get/set方法），以读取和改变数值。正如在第22章中看到的，对OOP而言，这是最优雅的方式，而且这也是JavaBean的基本原理。

26，不要错误的认为Java总是将当前目录视作查找行为的起点之一，如果你的CLASSPATH之中缺少一个“.”作为路径之一的话，Java就不会查找那里。

27，如果创建了一个新包，并自另一个包中继承类，那么唯一可以访问的成员就是源包的public成员，当然，如果在同一包中继承类，就可以操纵所有的拥有包访问权限的成员。

28，注意，类既不可以是private的（这样会使得除该类之外，其他任何类都不可以访问它），也不可以是protected的（事实上，一个内部类可以是private或者protected的），对于类的访问权限，仅有两个选择，public或包访问权限。

29，相同目录下的所有不具有明确package声明的文件，都被视作是该目录下默认包的一部分。

30，为了继承，一般的规则是将所有数据成员都指定为private，将所有方法指定为public。

31，如果没有默认的基类构造器，或者想调用一个带参数的基类构造器，就必须用关键字super显式地编写调用基类构造器的语句，并且配以适当的参数列表。

32, 到底是该用组合还是用继承，一个最清晰的判断方法就是问一问自己是否需要从新类向基本类型向上转型。如果必须向上转型，则继承是必要的；但如果不需要，则应当好好考虑自己是滞需要继承。-p140

33，一个既是static又是final的域只占据一段不能改变的存储空间。-p140

34，
    public static final int VALUE = 20;
    是一种典型的对常量进行定义的方式，定义为public，则可以被用于包之外；定义为static，则强调只有一份；定义为final，则说明它是一个常量。

35，final参数，Java允许在参数列表中以声明的方式将参数指明为final。这意味着这意味着你无法在方法中更改参数引用所指向的对象。这一特性主要是向匿名内部类传递数据。-p143

36，Java中除了static方法和final方法之外，其他所有的方法都是后期绑定。

37，在一个设计良好的OOP程序中，大多数或者所有方法都遵循turn()的模型，而且只与基类接口通信。这样的程序是可扩展的，因为可以从通用的基类继承出亲折数据类型，从而新添一些功能。那些操纵基类接口的方法不需要任何改动就可以应用于新类。

38，多态是一项让程序员“将改变的事物与未变的事物分离开来”的重要技术。

39，编写构造器时有一条有效的准则：“用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其他方法”。在构造器内唯一能够安全调用的那些方法是基类中的final方法（也适用于private方法，它们自动属于final方法）。这些方法不能被覆盖，因此也就不会出现上述令人惊讶的问题。 -p164

40，一条能用准则是：“用继承表达行为间的差异，并用字段表达状态上的变化”。在上述例子中，两者都用到了：通过继承得到了两个不同的类，用于表达act()方法的差异；而Stage通过运用组合使自己的状态发生变化。在这种情况下，这种状态的改变也就产生了行为的改变。 -p165

41, 像本例这样，创建一个能够根据所传递参数对象的不同而具有不同行为的方法，被称为策略模式。这类方法包含所有执行的算法中固定不变的部分，而“策略”包含变化的部分。-p175

42，放入接口的中域自动是static和final的。

43，想要直接创建内部类对象，你不能按你想像的方式，去引用外部类的名字，而是必须使用外部类的对象来创建该内部类对象。在拥有外部类对象之前，是不可能创建内部类对象的，这是因为内部类对象会暗暗地连接到创建它的外部类对象上，但是，如果你创建的是嵌套类（静态内部类），那么它就不需要对外部类对象的引用。

44，当内部类向上转型为其基类，尤其是转型为一个接口的时候，内部类就有了用武之地。这是因为此内部类——某个接口的实现——能够完全不可见，并且不可用。所得到的只是指向基类或接口的引用，所以能够很方便的隐藏实现细节。

45，任何抽象性都应该是应真正的需求而产生的。当必需时，你应该重构接口而不是到处添加额外的间接性，并由此带来额外的复杂性。这种额外的复杂性非常显著，如果你让某人去处理这种复杂性，只是因为你意识到由于以防万一而添加了新接口，而没有其他更有说服力的原因，那么好吧，如果我碰上这种事，就是质疑此人所作的所有设计。 -p189

46，恰当的原则应该是优先选择类而不是接口。从类开始，如果接口的必需性变得非常明确，那么就进行重构。接口是一种重要的工具，但是它们容易被滥用。 -p189

47，如果不需要内部类对象与其外围类对象之间有联系，那么可以将内部类声明为static。这通常称为嵌套类。

48，普通内部类的字段与方法，只能放在类的外部层次上，所以普通的内部类不能有static数据和方法，也不能饮食嵌套类，但是嵌套类可以包含所有这些东西。

49，为什么需要内部类？
    一般来说，内部类继承自某个类或者实现某个接口，内部类的代码操作创建它的外围类的对象。所以可以认为内部类提供了某种进入其外围类的窗口。
    内部类必需要回答的一个问题是：如果只是需要一个对接口的引用，为什么不通过外围类实现那个接口呢？答案是：如果这能满足需求，那么就应该这么做！
    那么内部类实现一个接口与外围类实现这个接口有什么区别呢？答案是：后者不能总享用到接口带来的方便，有时需要用到接口的实现。
    所以，使用内部类最吸引人的原因是：每个内部类都能独立的继承自一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
    内部类使得多重继承的解决方案变得完整。接口解决了部分问题，而内部类有效地实现了“多重继承”，也就是说，内部类允许继承多个非接口类型。
    如果不需要解决“多重继承”的问题，那么自然可以用另的方式编码，而不需要使用内部类。但如果使用内部类，还可以获得其他一些特性：
        1）内部类可以有多个实例，每个实例都有自己的状态信息，并且与外围类对象的信息相互独立。
        2）在单个外围类中，可以让多个内部类以不同的方式实现同一接口，或继承同一个类。
        3）创建内部类对象的时刻并不依赖于外围类对象的创建。
        4）内部类并没有令人迷惑的“is-a”的关系； 它就是一个独立的实体。举个例子，如果 Sequence.java不使用内部类，就必须声明“Sequence 是一个 Selector”，对于某个特定的Sequence只能有一个Selector。然而使用内部类很容易就能拥有另一个方法 reverseSelector()，用它来生成一个反向遍历序列的Selector。只有内部类才有这种灵活性。

50，闭包（closure）是一个可调用的对象，它记录了一些信息，这些信息来自于创建它的作用域。通过这个定义，可以看出内部类是面向对象的闭包，因为它不仅包含外围类对象（创建内部类的作用域）的信息，还自动拥有一个指向此外围类对象的引用，在此作用域内，内部类有权限操作所有成员，包括private成员。

51，应用程序框架（application framework）就是被设计用来解决某类特定问题的一个类或一组类。要运用某个应用程序框架，通常是继承一个或多个类，并覆盖某些方法。在覆盖后的方法中，编写方法定制框架提供的通用解决方案，以解决你的特定问题（这是设计模式中模板方法的一个例子）。模板方法包含算法的基本结构，并且会调用一个或多个可覆盖的方法，以完成算法的动作。设计模式总是将变化的事物与不变的事物分开，在这个模式中，模板方法是保持不变的事物，而可覆盖的方法就是变化的事物。

52，Collection，一个独立元素的序列，这些元素都服从一条或多条规则,List必须按照插入的顺序保存元素，而Set不能有重复元素,Queue按照队列规则来确定对象产生的顺序。
    Map，一组成对的“键值对”对象，允许你使用键来查找值。ArrayList允许你使用数字来查找值，因此在某种意义上讲，它将数字与对象关联在一起。

53，List<Apple> apples = new ArrayList<Apple>(); // 使用接口的目的在于如果你决定去修改你的实现，你所需的只是在创建处修改它
    List<Apple> apples = new LinkedList<Apple>();

54，在java.util包中的Arrays和Collections类中都有很多实用方法。

55，Collection的构造器可以接受另一个Collection，用它来将自身初始化，但是，Collection.addAll()方法运行起来要快的多，而且构建一个不包含元素的Collection，然后调用Collection.addAll()这种方式很方便，因此它是首选方式。

56，ArrayList和LinkedList都是List类型，他们之间的不同之处不仅在于执行某些类型的操作时的性能，而且LinkedList包含的操作也多于ArrayList。

57，HashSet使用了相当复杂的方式来在存储元素，这种技术是最快的获取元素的方式，因此，存储的顺序并不意义。如果存储顺序很重要，那么可以使用TreeSet，它按照比较结果的升序保存对象，或者使用LinkedHashSet，它按照被添加的顺序保存对象。

58，与HashSet一样，HashMap也提供了最快的查找技术，也没有按照任何明显的顺序来保存其元素。TreeMap按照比较结果的升序保存键，而LinkedHashMap则按照插入的顺序保存键，同时还保留了HashMap的查询速度。

59，List接口在Collection的基础上添加了大量的方法，使得可以在List的中间插入和移除元素。有两种类型的List：
        ArrayList，它长于随机访问元素，但在List的中间插入和移除元素较慢
        LinkedList，它通过代价较低的在List中间进行的插入和删除操作，提供了优化的顺序访问。LinkedList在随机访问方面相对比较慢，但是它的特性集较ArrayList更大。

60，对于LinkedList，在列表中间插入和删除都是廉价操作，但是对于ArrayList，这可是代价高昂的操作。这是否意味着你应该永远都不要在ArrayList的中间插入元素，并且最好是切换到LinkedList？不，这仅仅意味着，你应该意识到这个问题，如果你开始在某个ArrayList的中间执行很多插入操作，并且你的程序开始变慢，那么你应该看看你的List实现有可能就是罪魁祸首（发现此瓶颈的最佳方式就是防真器）。优化是一个很棘手的问题，最好的策略就是置之不顾，直到你发现需要担心它了。

61，迭代器，也是一种设计模式，iterator，也是一个对象，它的工作是遍历并选择序列中的对象。Java中的Iterator只能单向移动，使用iterator()方法要求容器返回一个Iterator。迭代器统一了对容器的访问方式。

62，ListIterator是一个更加强大的Iterator子类型，它只能用于各种List类的访问。尽管Iterator只能向前移动，但是ListIterator可以双向移动，还可以产生相对于迭代器在列表中指向的当前位置的前一个和后一个元素的索引，并且可以使用set()方法替换它访问过的最后一个元素。可以通过调用listIterator()方法得到一个指向List开始处的ListIterator。

63，LinkedList也像ArrayList一样实现了基本接口，但是它执行某些操作（在List中间插入和移除）时比ArrayList更高效，但在随机访问方面要逊色一些。

64，LinkedList 还添加了使其用作栈、队列或者双端队列的方法。

65，Set中最常被使用的是测试归属性，因此你通常都会选择一个HashSet的实现，它专门对快速查找进行了优化。Set具有与Collection完全一样的接口，因此没有任何额外的功能。Set是基于对象的值来确定归属性的。

66，出于速度的原因，HashSet使用了散列,因此，输出的顺序没有任何规律可循。HashSet所维护的顺序与TreeSet或LinkedHashSet都不同，因为它们的实现具有不同的元素存储方式。TreeSet将元素存储在红-黑树数据结构中，而HashSet使用的是散列函数。LinkedHashSet因为查询速度的原因也使用了散列，但是看起来它使用了链表来维护元素的插入顺序。如果你想对结果进行排序，一种方式是使用TreeSet来代替HashSet

67，Java SE5 引入了新的被称为Iterable的接口，该接口包含一个能够产生Iterator的iterator()方法，并且Iterable接口被foreach用来在序列中移动。因此如果你创建了任何实现了Iterable的类，都可以将它用于foreach语句中。

68，意识到Array.asList()产生的List对象会使用底层数组作为其物理实现是很重要的。只要你执行的操作会修改这个List，并且你不想原来的数组被修改，那么你就应该在另一个容器中创建一个副本。

69，Map和Collection之间的唯一重叠就是Map可以使用entrySet()和values()方法来产生Collection。

70，如果必须对传递给方法的每个引用都检查其是否为null（因为无法确定调用者是否传入了非法引用 ），这听起来着实吓人。幸运的是，这不必由你亲自来做，它属于Java的标准运行时检测的一部分。如果对null进行调用，Java会自动抛出NullPointerException异常，所以上述代码是多余的，尽管你也许想要执行其他的检查以确保NullPointerException不会出现。

71，属于运行时异常的类型有很多，它们会自动被Java虚拟机抛出，所以不必在异常说明中把它们列出来。这些异常都是从RuntimeException继承而来的，所以既体现了继承的优点，使用起来也很方便。这构成了一组具有相同特征和行为的异常类型，它们也被称为“不受检查异常”。这种异常属于错误，将被自动捕获。

72，请务必记住：只能在代码中忽略RuntimeException类型的异常，其他类型异常的处理都是由编译器强制实施的。究其原因，RuntimeException代表的是编程错误：
        1）无法预料的错误。比如你从控制范围之外传递进来的null引用
        2）作为程序员，应该在代码中进行检查的错误。（比如对于ArrayIndexOutOfBoundsException，就得注意下数组的大小）

73，当你为一个类编写toString()方法时，如果字符串操作比较简单，那就可以信赖编译器，它会为你合理地构造最终的字符串结果。但是，如果你要在toString()方法中使用循环，那么最好自己创建一个StringBuilder对象，用它来构造最终的结果。

74，StringBuilder是Java SE5引入的，在这之前用的是StringBuffer，后者是线程安全的，因此开销也会大些。

75，元组（tuple），它是将一组对象直接打包存储于其中的一个单一对象。这个容器对象允许读取其中的元素，但是不允许向其中存放新对象（这个概念也称为数据传送对象,或信使）。通常，元组可以具有任意长度，并且元组中的对象可以是任意不同的类型。

76，注意，当使用泛型类时，必须在创建对象的时候指定类型参数的值，而使用泛型方法的时候，通常不必指明参数类型，因为编译器会为我们找出具体的类型。这称为“类型参数推断（type argument inference）”。

77，在泛型代码内部,无法获得任何有关泛型参数类型的信息。因此，你可以知道诸如类型参数标识符和泛型类型边界这类信息——你却无法知道用来创建某个特定实例的实际的类型参数。Java泛型是使用擦除来实现的，这意味着当你在使用泛型时，任何具体的类型信息都被擦除了，你唯一知道的就是你在使用一个对象。因此，List<String>和List<Integer>在运行时事实上是相同的类型。这两种形式都被擦除成它们的“原生”类型，即List。理解擦除以及应该如何处理它，是你在学习Java泛型时面临的最大障碍。

78，为了减少潜在的关于擦除的混淆，你必须清楚地认识到这不是一个语言特性。它是Java中泛型实现中的一种折中，因为泛型不是Java语言出现时就有的组成部分，所以这种折中是必须的。

79，在基于擦除的实现中，泛型类型被当作第二类类型处理，即不能在某些重要的上下文环境中使用的类型。泛型类型只有在静态类型检查期间才出现，在此之后，程序中所有泛型类型都将被擦除，替换为它们的非泛型上界。例如，诸如List<T>这样的类型注解将被擦除为List，而普通的类型变量在未指定边界的情况下将被擦除为Object。

80，擦除的核心动机是它使得泛化的客户端可以用非泛化的类库来使用，反之亦然，这经常被称为“迁移兼容性”。通过允许泛型和非泛型代码共存，擦除使得这种向着泛型的迁移成为可能。

81，所有Collection子类型都有一个接收另一个Collection对象的构造器，用所接收的Collection对象中的元素来填充新的容器。

82，InputStream的作用是用来表示那些从不同数据源产生输入的类：
    1），字节数组
    2），String对象
    3），文件
    4），“管道”，工作方式与实际管道相似，即，从一端输入，从另一端输出。
    5），一个由其他种类的流组成的序列，以便我们将它们收集合并到一个流内。
    6），其他数据源，如Internet连接等。

83，每一种数据源都有相应的InputStream子类，另外，FilterInputStream也属于一种InputStream，是“装饰器”（decorator）类的基类。

84，装饰器模式也有一个缺点：在编写程序时，它给我们提供了相当多的灵活性（因为我们可以很容易的混合和匹配属性），但是它同时也增加了代码的复杂度。Java I/O类库操作不便的原因在于：我们必须创建许多类——“核心”I/O类型加上所有装饰器，才能得到我们所希望的单个I/O对象。

85，BufferedOutputStream是一个修改过的OutputStream，它对数据流使用缓冲技术，因此当每次向流写入时，不必每次都进行实际的物理写操作。所以在进行输出时，我们可能更经常的使用它。

86，FilterOutputStream类型：
    DataOutputStream，与DataInputStream搭配使用，可以按照可移植的方式向流中写入基本类型数据（char,int,long...)
    PrintStream，用于产生格式化输出，其中DataOutputStream处理数据的存储，PrintStream处理显示
    BufferedOutputStream，使用它可以避免每次发送数据时都要进行实际的写操作。代表“使用缓冲区”，可以调用flush()清空缓冲区。

87，Java1.1对基本的I/O流类库进行了重大的修改，增加了Reader和Writer类。InputStream和OutputStream在以面向字节形式的I/O中仍可以提供极有价值的功能，Reader和Writer则提供兼容Unicode与面向字符的I/O功能。

88，有时我们必须把来自于“字节”层次结构中的类和“字符”层次结构中的类结合起来使用，为了实现这个目的，要用到“适配器”（adapter）类：InputStreamReader可以把InputStream转换为Reader，而OutputStreamWriter可以把OutputStream转换为Writer。

89，设计Reader和Writer继承层次结构主要是为了国际化，老的I/O流继承层次结构仅支持8位字节流，并且不能很好的处理16位的Unicode字符。由于Unicode用于字符国际化（Java本身的char也是16位的Unicode），所以添加Reader和Writer继承层次结构就是为了在所有的I/O操作中都支持Unicode。另外，新类库的设计使得它的操作比旧类库更快。

90，在两各不能的继承层次结构中，信息的来源和去处：
    InputStream                             Reader
                                            Adapter: InputStreamReader
    OutputStream                            Writer
                                            Adapter: OutputStreamWriter
    FileInputStream                         FileReader
    FileOutputStream                        FileWriter
    StringBufferInputStream(Deprecated)     StringReader
    (No correspond class)                   StringWriter
    ByteArrayInputStream                    CharArrayReader
    ByteArrayOutputStream                   CharArrayWriter
    PipeInputStream                         PipeReader
    PipeOutputStream                        PipeWriter

91，更改流的行为：
    FilterInputStream                       FilterReader
    FilterOutputStream                      FilterWriter
    BufferedInputStream                     BufferedReader(also has readLine() method)
    BufferedOutputStream                    BufferedWriter
    DataInputStream                         Use DataInputStream(except need to use readLine() method, then you should use BufferedReader)
    PrintStream                             PrintWriter
    LineNumberInputStream(Deprecated)       LineNumberReader
    StreamTokenizer                         StreamTokenizer(Use constructor with Reader object)
    PushbackInputStream                     PushbackReader

92，JavaSE5中内置了3种标准注解：
    @Override
    @Deprecated
    @SuppressWarnings

93，内置了4种元注解:
    @Target, 表示该注解可以用于什么地方，可能的ElementType参数包括：
        CONSTRUCTOR: 构造器声明
        FIELD: 域声明
        LOCAL_VARIABLE: 局部变量声明
        METHOD: 方法声明
        PACKAGE: 包声明
        PARAMETER: 参数声明
        TYPE: 类，接口（包括注解类型）或enum声明
    @Retention, 表示需要在什么级别保存该注解的信息，可能的Retention参数包括：
        SOURCE: 注解将被编译器丢弃
        CLASS: 注解在class文件中可用，但会被VM丢弃
        RUNTIME: VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息。
    @Documented, 将该注解包含在Javadoc中
    @Inherited, 允许子类继承父类中的注解
